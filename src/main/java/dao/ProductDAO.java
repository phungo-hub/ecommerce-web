package dao;

import model.Eyeglasses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver jdbc connection!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not find databse");
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertProduct(Eyeglasses e) {

    }

    @Override
    public List<Eyeglasses> listAllEyeglasses() throws SQLException {
        String query = "SELECT * FROM eyeglasses order by cast(id as unsigned);";
        List<Eyeglasses> eyeglasses = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String url = rs.getString("url");

            Eyeglasses e = new Eyeglasses(id, name, price, quantity, url);
            eyeglasses.add(e);
        }
        return eyeglasses;
    }

    @Override
    public List<Eyeglasses> searchNameOrID(String search) throws SQLException {
        List<Eyeglasses> eyeglasses = new ArrayList<>();
        String query = "SELECT * FROM eyeglasses WHERE id like ? '%' OR `name` like ? '%';";
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, search);
        stmt.setString(2, search);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String url = rs.getString("url");
            Eyeglasses e = new Eyeglasses(id, name, price, quantity, url);

            eyeglasses.add(e);
        }
        return eyeglasses;
    }

    @Override
    public Eyeglasses selectEyeglasses(String id) throws SQLException {
        Eyeglasses eye = null;
        String query = "SELECT * FROM eyeglasses WHERE id = ?;";
        try (Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String user_id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int qty = rs.getInt("quantity");
                String url = rs.getString("url");

                eye = new Eyeglasses(user_id, name, price, qty, url);
            }
        }
        return eye;
    }

    @Override
    public boolean updateEyeglasses(Eyeglasses e) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEyeglasses(int id) throws SQLException {
        return false;
    }
}
