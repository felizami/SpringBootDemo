/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao;

import com.anuz.dummyapi.entity.Content;
import com.anuz.dummyapi.entity.ContentUpdateStatus;
import java.util.List;

/**
 *
 * @author anuz
 */
public interface ContentUpdateDAO extends GenericDAO<ContentUpdateStatus>{
    List<ContentUpdateStatus> getByClientId(int clientId);
    
    List<Content> getUnsynchronizedContentList(int clientId);
    int updateContentStatus(int ClientId,Boolean status);
    
    ContentUpdateStatus getLatestHTMLContentByClientId(int clientId);
    
    
}
