package com.josebonilla.evaluacionfinal.service.Impl;

import com.josebonilla.evaluacionfinal.repo.IGenericRepo;
import com.josebonilla.evaluacionfinal.service.ICRUDOperations;

import java.util.List;

public abstract class CRUDOperationsImpl<T, ID> implements ICRUDOperations<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t){

        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) {

        return getRepo().findById( id ).orElseThrow();
    }

    @Override
    public void delete(ID id) {

        getRepo().deleteById(id);
    }
}
