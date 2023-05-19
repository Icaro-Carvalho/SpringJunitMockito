package br.com.icaro.api.services;

import java.util.List;

import br.com.icaro.api.domain.User;
import br.com.icaro.api.domain.dto.UserDTO;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();
	
	User create(UserDTO userDTO);
}
