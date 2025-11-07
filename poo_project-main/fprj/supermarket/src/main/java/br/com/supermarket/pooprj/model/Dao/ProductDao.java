    package br.com.supermarket.pooprj.model.Dao;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

    import br.com.supermarket.pooprj.model.Product;

    public class ProductDao {

        // salva e retorna número de linhas afetadas (1 = ok)
        public int save(Product p) {
            String sql = "INSERT INTO tbproducts (name, quantity, value) VALUES (?, ?, ?)";
            try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, p.getName());
                // se quantity for Long no Product:
                ps.setLong(2, p.getQuantity());
                ps.setFloat(3, p.getValue());

                return ps.executeUpdate(); // 1 se inseriu
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        public List<Product> list() {
            List<Product> products = new ArrayList<>();
            String sql = "SELECT * FROM tbproducts";

            try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getLong("id"));
                    p.setName(rs.getString("name"));
                    p.setQuantity(rs.getLong("quantity"));
                    p.setValue(rs.getFloat("value"));
                    products.add(p);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return products;
        }
        public static void main(String[] args) {
    ProductDao dao = new ProductDao();
    Product p = new Product();
    p.setName("pao");
    p.setQuantity(20L);
    p.setValue(20.0f);

    int linhas = dao.save(p);
    System.out.println("Linhas afetadas: " + linhas);
}
    }
