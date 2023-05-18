package br.com.icaro.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icaro.api.domain.User;
import br.com.icaro.api.repositories.UserRepository;
import br.com.icaro.api.services.UserService;
import br.com.icaro.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(Integer id) {
		Optional<User> userId = userRepository.findById(id);
		return userId.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
