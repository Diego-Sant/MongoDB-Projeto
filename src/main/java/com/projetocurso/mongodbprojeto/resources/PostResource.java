package com.projetocurso.mongodbprojeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetocurso.mongodbprojeto.domain.Post;
import com.projetocurso.mongodbprojeto.resources.util.URL;
import com.projetocurso.mongodbprojeto.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	// O controlador REST(UserResource) acessa o serviço, e o serviço acessa o repositório
	@Autowired
	private PostService service;

	// Buscar posts por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch") // Usado @RequestParam pois depois de /titlesearch não será usado "/" e sim "?text="
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
}
