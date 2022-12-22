package com.projetocurso.mongodbprojeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetocurso.mongodbprojeto.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
