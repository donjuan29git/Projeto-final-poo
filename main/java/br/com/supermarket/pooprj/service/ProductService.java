package br.com.supermarket.pooprj.service;

import java.util.List;

import br.com.supermarket.pooprj.model.domain.Product;

public interface ProductService {

	void save(Product product);
	
	void update(Product product);
	
	void delete(Long id);
	
	Product findById(Long id);
	
	List<Product> findAll();
	
}
