/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.service;

//import com.anuz.dummyapi.dao.UserDAO;
import com.anuz.dummyapi.dao.UserDAO;
import org.springframework.stereotype.Service;
//import com.anuz.dummyapi.dao.UserRepository;
import com.anuz.dummyapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import java.util.List;

/**
 *
 * @author anuz
 */
@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;
    
    
    
    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User getById(int id) {
        return userDAO.getById(id);
    }

    public int saveOrUpdate(User user) {
        return userDAO.saveOrUpdate(user);
    }

    public int delete(int id) {
        return userDAO.delete(id);
    }

    public User userByEmail(String email) {
        return userDAO.userByEmail(email);
    }
    
    public Boolean contentUpdateStatus(int userId){
        return userDAO.getContentUpdateStatus(userId);
    }

//    public User saveUser(User user) {
//        return userRepository.saveAndFlush(user);
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User findOne(Long id) {
//        return userRepository.findOne(id);
//    }
//
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public void delete(Long Id) {
//        userRepository.delete(Id);
//    }

//    public User userByEmail(String email) {
//        return userDAO.userByEmail(email);
//    }

}
