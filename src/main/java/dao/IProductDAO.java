package dao;

import model.Eyeglasses;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Eyeglasses e);
    public List<Eyeglasses> listAllEyeglasses() throws SQLException;
    public List<Eyeglasses> searchNameOrID(String search) throws SQLException;
    public Eyeglasses selectEyeglasses(String id) throws SQLException;

    public boolean updateEyeglasses(Eyeglasses e) throws SQLException;
    public boolean deleteEyeglasses(int id) throws SQLException;
}
