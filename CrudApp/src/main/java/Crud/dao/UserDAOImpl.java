package Crud.dao;

import Crud.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManger;
   private final SessionFactory sessionFactory;

   @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> getAll() {
    return   entityManger.createQuery("select u from User u ",User.class).getResultList();
//       Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("select u from User u ",User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserbyId(int id) {
       return entityManger.find(User.class,id);

//       Session session = sessionFactory.getCurrentSession();
//       User user = session.get(User.class,id);
//       return user;
    }

    @Override
    @Transactional
    public void add(User user) {
       entityManger.persist(user);
//    Session session = sessionFactory.getCurrentSession();
//    session.save(user);
    }

    @Override
    @Transactional
    public void edit(int id, User userUpdate) {
       entityManger.merge(userUpdate);
//    Session session = sessionFactory.getCurrentSession();
//    User updatedUser = session.get(User.class, id);
//    updatedUser.setName(userUpdate.getName());
//    updatedUser.setSurname(userUpdate.getSurname());
//    updatedUser.setAge(userUpdate.getAge());
    }

    @Override
    @Transactional
    public void delete(int id) {
       entityManger.remove(getUserbyId(id));
//    Session session = sessionFactory.getCurrentSession();
//    User user = session.get(User.class,id);
//    session.delete(user);
    }

}
