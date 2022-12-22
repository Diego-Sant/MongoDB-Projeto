package com.projetocurso.mongodbprojeto.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetocurso.mongodbprojeto.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// Buscar todos os usuários no /users
	@GetMapping // ResponseEntity é usado para retornar resposta HTTP que ajuda a localizar um possível erro
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
	
}
