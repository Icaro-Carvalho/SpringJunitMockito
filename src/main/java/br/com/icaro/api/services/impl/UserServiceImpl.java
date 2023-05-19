package br.com.icaro.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.icaro.api.domain.User;
import br.com.icaro.api.domain.dto.UserDTO;
import br.com.icaro.api.repositories.UserRepository;
import br.com.icaro.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User findById(Integer id) {
		Optional<User> userId = userRepository.findById(id);
		return userId.orElse(null);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(UserDTO userDTO) {
		return userRepository.save(mapper.map(userDTO, User.class));
	}

}
