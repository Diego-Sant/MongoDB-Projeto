package com.projetocurso.mongodbprojeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocurso.mongodbprojeto.domain.User;
import com.projetocurso.mongodbprojeto.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	// Usado DTO em UserService ao em vez do UserDTO para facilitar uma possível manutenção no banco de dados
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
	}
	
}
