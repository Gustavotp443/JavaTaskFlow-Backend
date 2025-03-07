package com.JavaTaskFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaTaskFlow.models.User;
import com.JavaTaskFlow.repositories.UserRepository;
import com.JavaTaskFlow.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		 return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
