/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.service;

import com.anuz.dummyapi.dao.UserContentDAO;
import com.anuz.dummyapi.entity.Content;
import com.anuz.dummyapi.entity.User;
import com.anuz.dummyapi.entity.UserContent;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anuz
 */
@Service
public class UserContentService {
    @Autowired
    UserContentDAO userContentDAO;
            
    
    public List<UserContent> getAll() {
        return userContentDAO.getAll();
    }

    public UserContent getById(int id) {
        return userContentDAO.getById(id);
    }

    public int saveOrUpdate(UserContent user) {
        return userContentDAO.saveOrUpdate(user);
    }

    public int delete(int id) {
        return userContentDAO.delete(id);
    }
    
    public UserContent getContentStatusById(int userId){
        return userContentDAO.getByUserId(userId);
    }

    
}
