package br.com.supermarket.pooprj.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.supermarket.pooprj.model.User;

public class UserDao implements Dao<User> {

    @Override
    public List<User> list() {   
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM tbusers"; 
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    @Override
    public User get(Long id) {
        User user = null;
        String sql = "SELECT * FROM tbusers WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public int add(User user) {   
        String sql = "INSERT INTO tbusers (username, password) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.execute();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    @Override
    public boolean update(User user, String[] params) {
        String sql = "UPDATE tbusers SET username = ?, password = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setLong(3, user.getId());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "DELETE FROM tbusers WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, user.getId());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

     public boolean login(String username, String password) {
        String sql = "SELECT * FROM tbusers WHERE username = ? AND password = ?";
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet resultado = null;

        try {
            conexao = DBConnection.getConnection();
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, username);
            comandoSQL.setString(2, password);
            resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception erro) {
            System.out.println("Erro ao tentar logar: " + erro.getMessage());
            return false;

        } finally {
            try {
                if (resultado != null) resultado.close();
                if (comandoSQL != null) comandoSQL.close();
                if (conexao != null) conexao.close();
            } catch (Exception erroFechar) {
                System.out.println("Erro ao fechar recursos: " + erroFechar.getMessage());
            }
        }
    }
}
