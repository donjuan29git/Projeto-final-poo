package br.com.supermarket.pooprj.model.Dao;

import java.util.List;

public interface Dao<T> { 
    Object get(Long id);
    List<T> list();
    int add(T t);
    boolean update(T t, String[] params);
    boolean delete(T t);
}