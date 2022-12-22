package com.projetocurso.mongodbprojeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetocurso.mongodbprojeto.domain.User;
import com.projetocurso.mongodbprojeto.dto.UserDTO;
import com.projetocurso.mongodbprojeto.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// O controlador REST(UserResource) acessa o serviço, e o serviço acessa o repositório
	@Autowired
	private UserService service;

	// Buscar todos os usuários no /users
	@GetMapping // ResponseEntity é usado para retornar resposta HTTP que ajuda a localizar um possível erro
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
