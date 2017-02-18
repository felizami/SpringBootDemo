/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.service;

import com.anuz.dummyapi.dao.ContentDAO;
import com.anuz.dummyapi.entity.Content;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anuz
 */
@Service
public class ContentService {
    @Autowired
    ContentDAO contentDAO;
    
    public List<Content> getAll() {
        return contentDAO.getAll();
    }

    public Content getById(int id) {
        return contentDAO.getById(id);
    }

    public int saveOrUpdate(Content content) {
        return contentDAO.saveOrUpdate(content);
    }

    public int delete(int id) {
        return contentDAO.delete(id);
    }
    
    
    
}
