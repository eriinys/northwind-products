import java.sql.*;

public class main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "yearup";

        String sql = "SELECT ProductName FROM products";

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String ProductName = rs.getString("ProductName");
                System.out.println(ProductName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
