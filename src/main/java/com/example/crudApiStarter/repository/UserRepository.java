package com.example.crudApiStarter.repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.crudApiStarter.entity.User;

//public interface UserRepository extends CrudRepository<User, String> {

public interface UserRepository extends MongoRepository<User, String> {
	
	//@Query("select u from user u where u.name =: name")
	 public List<User> findByName(String name);

	
}
