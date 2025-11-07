package br.com.supermarket.pooprj.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.supermarket.pooprj.model.Venda;

public class VendaDao {
    public int save(Venda v) {
        String sql = "INSERT INTO tbvendas (name, price, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getName());
            ps.setDouble(2, v.getPrice());
            ps.setInt(3, v.getQuantity());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Listar vendas
    public List<Venda> list() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM tbvendas";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getLong("id"));
                v.setName(rs.getString("name"));
                v.setPrice(rs.getDouble("price"));
                v.setQuantity(rs.getInt("quantity"));
                vendas.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendas;
    }
}
