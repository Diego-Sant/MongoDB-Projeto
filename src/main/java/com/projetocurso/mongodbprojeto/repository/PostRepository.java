package com.projetocurso.mongodbprojeto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetocurso.mongodbprojeto.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// i significa ignorar letras maiúsculas e minúsculas
	// ?0 foi usado pois existe apenas um argumento
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	// $or irá buscar tanto no title quanto no corpo da postagem
	// $gte(greater than or equal) buscará valores maiores que o selecionado
	// $lte(less than or equal) buscará valores menores que o selecionado
	// Primeiro parâmetro é o ?0, segundo é o ?1 e por diante
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2} }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
