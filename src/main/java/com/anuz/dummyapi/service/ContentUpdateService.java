/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.service;

import com.anuz.dummyapi.dao.ContentUpdateDAO;
import com.anuz.dummyapi.entity.Content;
import com.anuz.dummyapi.entity.ContentUpdateStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anuz
 */
@Service
public class ContentUpdateService {
    @Autowired
    ContentUpdateDAO contentUpdateDAO;
            
    
    public List<ContentUpdateStatus> getAll() {
        return contentUpdateDAO.getAll();
    }

    public ContentUpdateStatus getById(int id) {
        return contentUpdateDAO.getById(id);
    }

    public int saveOrUpdate(ContentUpdateStatus user) {
        return contentUpdateDAO.saveOrUpdate(user);
    }

    public int delete(int id) {
        return contentUpdateDAO.delete(id);
    }
    
    public List<ContentUpdateStatus> getByClientId(int clientId){
        return contentUpdateDAO.getByClientId(clientId);
    }
    public List<Content> getUnsynchronizedContentList(int clientId){
        return contentUpdateDAO.getUnsynchronizedContentList(clientId);
    }

    public int updateContentStatus(int clientId,Boolean status){
        return contentUpdateDAO.updateContentStatus(clientId, status);
    }
    
    
     public ContentUpdateStatus getLatestContentByClientId(int clientId){
         return contentUpdateDAO.getLatestContentByClientId(clientId);
     }
    
    

    
}
