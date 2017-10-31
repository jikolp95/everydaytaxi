package com.everydaytaxi.userDao;

import com.everydaytaxi.models.User;
import com.everydaytaxi.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void addUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int userId) {

    }

    public void getUserList() {

    }

    public User getUser(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
