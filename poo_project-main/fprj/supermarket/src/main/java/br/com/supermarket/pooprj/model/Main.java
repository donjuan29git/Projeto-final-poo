package br.com.supermarket.pooprj.model;

import java.util.List;
import br.com.supermarket.pooprj.model.Dao.UserDao;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        User novoUsuario = new User();
        novoUsuario.setUsername("marco");
        novoUsuario.setPassword("234567");
        userDao.add(novoUsuario);
        System.out.println("Usuário inserido!");

        


        List<User> usuarios = userDao.list();
        System.out.println("Usuários cadastrados:");
        for (User u : usuarios) {
            System.out.println("ID: " + u.getId() + ", Nome: " + u.getUsername());
        }

        Long idBusca = 6L; 
        User usuarioBuscado = userDao.get(idBusca);
        if (usuarioBuscado != null) {
            System.out.println("Usuário encontrado: " + usuarioBuscado.getUsername());
        } else {
            System.out.println("Usuário não encontrado com ID: " + idBusca);
        }

        if (usuarioBuscado != null) {
            usuarioBuscado.setUsername("pedro_atualizado");
            usuarioBuscado.setPassword("nova_senha");
            userDao.update(usuarioBuscado, null);
            System.out.println("Usuário atualizado!");
        }

        if (usuarioBuscado != null) {
            userDao.delete(usuarioBuscado);
            System.out.println("Usuário deletado!");
        }

        boolean sucesso = userDao.login("nayara", "123456");

        if (sucesso) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Login falhou. Usuário ou senha inválidos.");
        }
    }
}
