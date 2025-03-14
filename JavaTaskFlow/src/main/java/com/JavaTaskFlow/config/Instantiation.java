package com.JavaTaskFlow.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.JavaTaskFlow.models.AuthProvider;
import com.JavaTaskFlow.models.Role;
import com.JavaTaskFlow.models.User;
import com.JavaTaskFlow.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		String encodedGustavoPassword = passwordEncoder.encode("netuno");
        String encodedJoaoPassword = passwordEncoder.encode("netuno"); 
		
		User gustavo = new User("Gustavo","gustavo@email.com",null,AuthProvider.LOCAL,"1",Role.ADMIN,encodedGustavoPassword);
		User joao = new User("Joao","joao@email.com",null,AuthProvider.LOCAL,"1",Role.MEMBER,encodedJoaoPassword);
		
		userRepository.saveAll(Arrays.asList(gustavo,joao));
	}

}
