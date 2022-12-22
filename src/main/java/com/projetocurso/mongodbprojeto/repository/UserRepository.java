package com.projetocurso.mongodbprojeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetocurso.mongodbprojeto.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
