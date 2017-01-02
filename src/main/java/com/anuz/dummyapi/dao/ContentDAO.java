/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao;

import com.anuz.dummyapi.entity.Content;
import java.util.List;

/**
 *
 * @author anuz
 */
public interface ContentDAO extends GenericDAO<Content>{
    Content getLastContent();
    List<Content> getUpdates(int userId);
}
