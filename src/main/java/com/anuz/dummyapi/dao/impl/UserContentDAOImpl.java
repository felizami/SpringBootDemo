/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao.impl;

import com.anuz.dummyapi.entity.UserContent;
import java.util.List;
import com.anuz.dummyapi.dao.UserContentDAO;
import com.anuz.dummyapi.entity.Content;
import com.anuz.dummyapi.entity.User;
import com.anuz.dummyapi.service.UserContentService;
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
public class UserContentDAOImpl implements UserContentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getAll() {
        List<UserContent> user;
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery("SELECT u FROM UserContent u").list();
        }
        return user;
    }

    @Override
    public UserContent getById(int id) {
        UserContent customerById;
        try (Session session = sessionFactory.openSession()) {
            customerById = (UserContent) session.get(UserContent.class, id);
        }
        return customerById;
    }

    @Override
    public int saveOrUpdate(UserContent user) {
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
            session.delete((UserContent) session.get(UserContent.class, id));
            transaction.commit();
        }
        return 1;
    }

    @Override
    public UserContent getByUserId(int userId) {
        UserContent userContent;
        try (Session session = sessionFactory.openSession()) {
            userContent = (UserContent) session.createQuery("SELECT u FROM UserContent u where u.userId.userId=:userId").setParameter("userId", userId).uniqueResult();
        }
        return userContent;
    }

    

}
