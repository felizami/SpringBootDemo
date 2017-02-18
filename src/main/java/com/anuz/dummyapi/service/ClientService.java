/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.service;

//import com.anuz.dummyapi.dao.UserDAO;
import com.anuz.dummyapi.dao.ClientDAO;
import org.springframework.stereotype.Service;
//import com.anuz.dummyapi.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.anuz.dummyapi.entity.Client;

/**
 *
 * @author anuz
 */
@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public List<Client> getAll() {
        return clientDAO.getAll();
    }

    public Client getById(int id) {
        return clientDAO.getById(id);
    }

    public int saveOrUpdate(Client user) {
        return clientDAO.saveOrUpdate(user);
    }

    public int delete(int id) {
        return clientDAO.delete(id);
    }

}
