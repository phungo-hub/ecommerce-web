package dao;

import model.Eyeglasses;

import java.util.List;

public interface IAdminDAO {
    List<Eyeglasses> listEyeglasses();
    void add(Eyeglasses e);
    Eyeglasses searchById(String id);
    boolean update(String id, Eyeglasses e);
    boolean delete(String id);

}
