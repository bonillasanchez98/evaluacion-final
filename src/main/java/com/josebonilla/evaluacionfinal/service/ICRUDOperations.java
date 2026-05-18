package com.josebonilla.evaluacionfinal.service;


import java.util.List;

public interface ICRUDOperations<T, ID> {

    T save(T t) ;
    T update(T t, ID id);
    List<T> readAll();
    T readById(ID id);
    void delete(ID id);
}
