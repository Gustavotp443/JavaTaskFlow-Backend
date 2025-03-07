package com.JavaTaskFlow.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.JavaTaskFlow.models.AuthProvider;
import com.JavaTaskFlow.models.Role;
import com.JavaTaskFlow.models.User;
import com.JavaTaskFlow.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User gustavo = new User("1","Gustavo","gustavo@email.com",null,AuthProvider.LOCAL,"1",Role.ADMIN,"123");
		User joao = new User("2","Joao","joao@email.com",null,AuthProvider.LOCAL,"1",Role.MEMBER,"123");
		
		userRepository.saveAll(Arrays.asList(gustavo,joao));
	}

}
