package com.java.tutorial.model;

import com.java.tutorial.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public interface Repository <T> {
    Connection connection = ConnectionBuilder.getConnection();
    void insert (T entity) throws DaoException;
    List<T> select() throws DaoException;
    T selectById (long id) throws DaoException;
    T selectByLogin (String login, String password) throws DaoException;
    boolean update (T entity) throws DaoException;
    void delete (T entity) throws DaoException;
    void deleteById (long id) throws DaoException;
}
