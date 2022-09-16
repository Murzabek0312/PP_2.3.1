package Crud.service;

import Crud.dao.UserDAOImpl;
import Crud.dao.UserDao;
import Crud.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.util.List;

@Component
public class ServiceUserImpl implements ServiceUser {
    private SessionFactory user;
    @Autowired
    private UserDao userDao = new UserDAOImpl(user);

    public ServiceUserImpl() {
    }

    @Transient
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
    @Transient
    @Override
    public User getUserbyId(int id) {
        return userDao.getUserbyId(id);
    }
    @Transient
    @Override
    public void add(User user) {
    userDao.add(user);
    }
    @Transient
    @Override
    public void edit(int id, User userUpdate) {
    userDao.edit(id,userUpdate);
    }
    @Transient
    @Override
    public void delete(int id) {
    userDao.delete(id);
    }
}
