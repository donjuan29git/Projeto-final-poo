package br.com.supermarket.pooprj.model.Dao;

import java.util.List;

import br.com.supermarket.pooprj.model.domain.Product;

public interface ProductDao {

    void save(Product product );

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();
}