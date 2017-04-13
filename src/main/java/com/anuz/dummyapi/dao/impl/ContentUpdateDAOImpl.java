/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao.impl;

import com.anuz.dummyapi.dao.ContentUpdateDAO;
import com.anuz.dummyapi.entity.Content;
import java.util.List;
import com.anuz.dummyapi.entity.ContentUpdateStatus;
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
public class ContentUpdateDAOImpl implements ContentUpdateDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getAll() {
        List<ContentUpdateStatus> contentUpdate;
        try (Session session = sessionFactory.openSession()) {
            contentUpdate = session.createQuery("SELECT u FROM ContentUpdateStatus u").list();
        }
        return contentUpdate;
    }

    @Override
    public ContentUpdateStatus getById(int id) {
        ContentUpdateStatus contentUpdate;
        try (Session session = sessionFactory.openSession()) {
            contentUpdate = (ContentUpdateStatus) session.get(ContentUpdateStatus.class, id);
        }
        return contentUpdate;
    }

    @Override
    public int saveOrUpdate(ContentUpdateStatus t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(t);

            transaction.commit();
        }
        return 1;
    }

    @Override
    public int delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete((ContentUpdateStatus) session.get(ContentUpdateStatus.class, id));
            transaction.commit();
        }
        return 1;
    }

    @Override
    public List<ContentUpdateStatus> getByClientId(int clientId) {
        List<ContentUpdateStatus> userContents;
        try (Session session = sessionFactory.openSession()) {
            userContents = session.createQuery("SELECT u FROM ContentUpdateStatus u where u.clientId.clientId=:clientId").setParameter("clientId", clientId).list();
        }
        return userContents;
    }

    @Override
    public List<Content> getUnsynchronizedContentList(int clientId) {
     List<Content> contentIdList;
        try (Session session = sessionFactory.openSession()) {
            contentIdList = session.createQuery("SELECT c.contentId FROM ContentUpdateStatus c where c.clientId.clientId=:clientId and c.status=TRUE").setParameter("clientId", clientId).list();
        }
        return contentIdList;
        
    }

    @Override
    public int updateContentStatus(int clientId,Boolean status) {
        int result;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            result=session.createQuery("Update ContentUpdateStatus c set c.status=:status where c.clientId.clientId=:clientId ").setBoolean("status",status).setParameter("clientId", clientId).executeUpdate();
            transaction.commit();
        }
        return result;
    }

    

}
