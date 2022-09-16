package Crud.dao;

import Crud.models.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public User getUserbyId(int id);
    public void add(User user);
    public void edit(int id, User userUpdate);
    public void delete(int id);
}
