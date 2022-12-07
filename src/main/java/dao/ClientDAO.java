package dao;

import model.Account;
import model.Role;

import java.sql.*;

public class ClientDAO {
    public static Account checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        String jdbcUsername = "root";
        String jdbcPassword = "admin";

        String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        String sql = "SELECT * FROM client_account WHERE username = ? AND password = ?;";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int permission = rs.getInt("permission");
            Role role = getRole(permission);
            Account account = new Account(username, role);
            return account;
        }
        else {
            return null;
        }
    }

    private static Role getRole(int permission) throws SQLException {
        Role role = Role.GUEST;
        if (permission == 1)
            role = Role.ADMIN;
        else if (permission == 2)
            role = Role.USER;
        return role;
    }
}
