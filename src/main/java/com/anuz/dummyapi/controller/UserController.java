/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.controller;

import com.anuz.dummyapi.entity.User;
import com.anuz.dummyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author anuz
 */
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());
        @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> allUsers() {
        logger.info("Retreive all Users");
        logger.debug("show this");
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok(id);
    }
    
    
    
//    @RequestMapping(value = "byEmail", method = RequestMethod.GET)
//    public User delete() {
//        return userService.userByEmail("anuj.maharjan@gmail.com");
//        
//        
//    }
//    
    

}
