package br.com.supermarket.pooprj.model.Dao;

import java.util.List;

import br.com.supermarket.pooprj.model.domain.Venda;

public interface VendaDao {

    void save(Venda venda );

    void update(Venda venda);

    void delete(Long id);

    Venda findById(Long id);

    List<Venda> findAll();
}