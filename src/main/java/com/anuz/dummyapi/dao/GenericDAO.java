/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.dao;

import java.util.List;

/**
 *
 * @author anuz
 * @param <T>
 */
public interface GenericDAO<T> {

    List<T> getAll();

    T getById(int id);

    int saveOrUpdate(T t);

    int delete(int id);

}
