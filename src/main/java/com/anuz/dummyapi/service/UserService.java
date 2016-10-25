/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.service;

import org.springframework.stereotype.Service;
import com.anuz.dummyapi.dao.UserRepository;
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
    
    @Autowired
    private UserRepository userRepository;
    
    
    public User saveUser(User user){
        Assert.notNull(user);
        return userRepository.saveAndFlush(user);
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        Assert.notNull(id);
        return userRepository.findOne(id);
    }
    public User findByEmail(String email) {
        Assert.hasLength(email);
        return userRepository.findByEmail(email);
    }
    public void delete(Long Id) {
        Assert.notNull(Id);
        userRepository.delete(Id);
    }
    
    
    
}
