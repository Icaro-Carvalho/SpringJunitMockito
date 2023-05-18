package br.com.icaro.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.icaro.api.domain.User;
import br.com.icaro.api.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public void startDB() {
		User user = new User(1, "Icaro", "icaro@email.com", "123");
		User user2 = new User(2, "Luiza", "luiza@email.com", "123");
		
		userRepository.saveAll(List.of(user, user2));
	}

}
