package com.projetocurso.mongodbprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocurso.mongodbprojeto.domain.User;
import com.projetocurso.mongodbprojeto.repository.UserRepository;
import com.projetocurso.mongodbprojeto.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	// O controlador REST(UserResource) acessa o serviço, e o serviço acessa o repositório
	@Autowired // Injeção de dependência automática
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
