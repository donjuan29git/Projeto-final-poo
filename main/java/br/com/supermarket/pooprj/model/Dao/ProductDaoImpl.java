package br.com.supermarket.pooprj.model.Dao;

import org.springframework.stereotype.Repository;

import br.com.supermarket.pooprj.model.domain.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Long> implements ProductDao {

}
