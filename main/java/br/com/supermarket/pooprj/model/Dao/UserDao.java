package br.com.supermarket.pooprj.model.Dao;

import java.util.List;

import br.com.supermarket.pooprj.model.domain.User;

public interface UserDao {

    void save(User user );

    void update(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> findAll();
}