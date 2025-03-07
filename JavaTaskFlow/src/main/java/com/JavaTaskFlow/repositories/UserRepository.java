package com.JavaTaskFlow.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.JavaTaskFlow.models.User;

//class,Id type
public interface UserRepository extends MongoRepository<User, String>{
	
}
