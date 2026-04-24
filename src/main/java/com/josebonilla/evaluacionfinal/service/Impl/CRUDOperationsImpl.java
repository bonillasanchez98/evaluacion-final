package com.josebonilla.evaluacionfinal.service.Impl;

import com.josebonilla.evaluacionfinal.repo.IGenericRepo;
import com.josebonilla.evaluacionfinal.service.ICRUDOperations;

import java.util.List;

public abstract class CRUDOperationsImpl<T, ID> implements ICRUDOperations<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow();
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow();
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow();
        getRepo().deleteById(id);
    }
}
