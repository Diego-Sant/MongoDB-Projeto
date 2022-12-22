package com.projetocurso.mongodbprojeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocurso.mongodbprojeto.domain.User;
import com.projetocurso.mongodbprojeto.repository.UserRepository;

@Service
public class UserService {

	// O controlador REST(UserResource) acessa o serviço, e o serviço acessa o repositório
	@Autowired // Injeção de dependência automática
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
}
