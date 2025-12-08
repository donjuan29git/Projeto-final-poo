package br.com.supermarket.pooprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.supermarket.pooprj.model.Dao.ProductDao;
import br.com.supermarket.pooprj.model.domain.Product;


@Service @Transactional(readOnly = false)
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;

	@Override
	public void save(Product product) {
		dao.save(product);		
	}

	@Override
	public void update(Product product) {
		dao.update(product);		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Product findById(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Product> findAll() {
		
		return dao.findAll();
	}
}