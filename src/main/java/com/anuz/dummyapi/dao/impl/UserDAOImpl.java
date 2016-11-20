/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao.impl;

import com.anuz.dummyapi.dao.UserDAO;
import com.anuz.dummyapi.entity.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuz
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;
    
    
    
    @Override
    public List<User> getAll() {
        List<User> user;
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery("SELECT u FROM User u").list();
        }
        return user;
    }

    @Override
    public User getById(int id) {
        User customerById;
        try (Session session = sessionFactory.openSession()) {
            customerById = (User) session.get(User.class, id);
        }
            return customerById;
    }

    @Override
    public int saveOrUpdate(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            
            session.saveOrUpdate(user);
            
            transaction.commit();
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete((User) session.get(User.class, id));
            transaction.commit();
        }
        return 1;
    }

    @Override
    public User userByEmail(String email) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            user = (User) session.createQuery("SELECT u FROM User u WHERE u.email=:email").setParameter("email", email).uniqueResult();
        }
        return user;
    }

}
