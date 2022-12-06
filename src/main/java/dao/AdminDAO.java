package dao;

import model.Eyeglasses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAdminDAO{
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
    public List<Eyeglasses> listEyeglasses() {
        String query = "SELECT * FROM eyeglasses";
        List<Eyeglasses> eyeglassesList = new ArrayList<>();

        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String url = rs.getString("url");

                Eyeglasses e = new Eyeglasses(id, name, price, quantity, url);
                eyeglassesList.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eyeglassesList;
    }

    @Override
    public void add(Eyeglasses e) {
        String query = "INSERT INTO eyeglasses VALUES (?,?,?,?,?);";
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, e.getId());
            stmt.setString(2, e.getName());
            stmt.setDouble(3, e.getPrice());
            stmt.setInt(4, e.getQuantity());
            stmt.setString(5, e.getUrl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Eyeglasses searchById(String id) {
        String query = "SELECT * FROM eyeglasses where id = ?;";
        Connection conn = getConnection();
        Eyeglasses eyes = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String user_id = rs.getString("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int qty = rs.getInt("qty");
                String url = rs.getString("url");

                eyes = new Eyeglasses(user_id, name, price, qty, url);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eyes;
    }

    @Override
    public boolean update(String id, Eyeglasses e) {
        String query = "UPDATE eyeglasses SET name = ?, price = ?, quantity = ?, url = ? WHERE id=?;";
        Connection conn = getConnection();
        boolean rowUpdated;
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, e.getName());
            stmt.setDouble(2, e.getPrice());
            stmt.setInt(3, e.getQuantity());
            stmt.setString(4, e.getId());
            rowUpdated = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM eyeglasses where id = ?;";
        return false;
    }
}
