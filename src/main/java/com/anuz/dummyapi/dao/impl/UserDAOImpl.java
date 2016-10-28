///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.anuz.dummyapi.dao.impl;
//
//import com.anuz.dummyapi.dao.UserDAO;
//import com.anuz.dummyapi.entity.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author anuz
// */
//@Repository
//public class UserDAOImpl implements UserDAO{
//    
//    @Autowired
//    SessionFactory sessionFactory;
//    
//    @Override
//     public User userByEmail(String email) {
//       Session session=sessionFactory.openSession();
//        User user=(User) session.createQuery("SELECT u FROM User u WHERE u.email=:email").setParameter("email", email).uniqueResult();
//        session.close();
//        return user;
//    }
//
//   
//    
//}
