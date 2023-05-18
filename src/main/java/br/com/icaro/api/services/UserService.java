package br.com.icaro.api.services;

import br.com.icaro.api.domain.User;

public interface UserService {

	User findById(Integer id);
}
