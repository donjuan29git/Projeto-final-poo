package br.com.supermarket.pooprj.model.Dao;

import org.springframework.stereotype.Repository;

import br.com.supermarket.pooprj.model.domain.User;

@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

}
