package com.JavaTaskFlow.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaTaskFlow.models.User;
import com.JavaTaskFlow.repositories.UserRepository;
import com.JavaTaskFlow.services.exception.BadCredentialsException;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
	    User existingUser = repository.findById(obj.getId())
	        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	    updateData(existingUser, obj);
	    return repository.save(existingUser);
	}

	private void updateData(User newObj, User obj) {
	    newObj.setName(obj.getName());
	    newObj.setEmail(obj.getEmail());
	    newObj.setPassword(obj.getPassword());
	    newObj.setProfileImageUrl(obj.getProfileImageUrl());
	    newObj.setAuthProvider(obj.getAuthProvider());
	    newObj.setCompanyId(obj.getCompanyId());
	    newObj.setRole(obj.getRole());
	    newObj.setUpdatedAt(Instant.now());
	}

	public User findByEmail(String email) {
		Optional<User> emailTest = repository.findByEmail(email);
		System.out.println(emailTest.get().getEmail());
		
		return repository.findByEmail(email)
				.orElseThrow(() -> new BadCredentialsException("usuário ou senha é invalido!"));
	}
}
