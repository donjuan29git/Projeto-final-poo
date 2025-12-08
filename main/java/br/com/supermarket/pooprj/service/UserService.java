//Esperando Springsecurity


package br.com.supermarket.pooprj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.supermarket.pooprj.model.domain.User;

public interface UserService extends UserDetailsService {

	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User findById(Long id);
	
	List<User> findAll();
	
}