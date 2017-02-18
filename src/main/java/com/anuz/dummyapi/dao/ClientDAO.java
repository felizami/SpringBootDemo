/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao;

import com.anuz.dummyapi.entity.Client;
/**
 *
 * @author anuz
 */
public interface ClientDAO extends GenericDAO<Client>{
    Boolean getContentUpdateStatus(int clientId);
   
      
}
