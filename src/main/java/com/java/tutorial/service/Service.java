package com.java.tutorial.service;

import com.java.tutorial.exception.ServiceException;

import java.util.List;

public interface Service<T> {
    public void create (T entity) throws ServiceException;
    public T read(long id) throws ServiceException;
    public List<T> readAll () throws ServiceException;
    public void update (T entity) throws ServiceException;
    public void delete (T entity) throws ServiceException;
    public void deleteById (long id) throws ServiceException;
    public List<T> createByLogin (String login, String password) throws ServiceException;

}
