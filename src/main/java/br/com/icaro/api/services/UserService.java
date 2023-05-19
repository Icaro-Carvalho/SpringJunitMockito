package br.com.icaro.api.services;

import java.util.List;

import br.com.icaro.api.domain.User;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();
}
