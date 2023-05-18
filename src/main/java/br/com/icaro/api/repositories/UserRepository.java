package br.com.icaro.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.icaro.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
