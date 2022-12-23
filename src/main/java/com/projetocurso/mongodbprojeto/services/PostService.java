package com.projetocurso.mongodbprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocurso.mongodbprojeto.domain.Post;
import com.projetocurso.mongodbprojeto.repository.PostRepository;
import com.projetocurso.mongodbprojeto.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	// O controlador REST(PostResource) acessa o serviço, e o serviço acessa o repositório
	@Autowired // Injeção de dependência automática
	private PostRepository repo;
	
	// Pegar post por Id
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	// Procurar por palavra chave em título
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
}
