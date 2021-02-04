package com.java.tutorial.service.impl;

import com.java.tutorial.entities.Order;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.model.Repository;
import com.java.tutorial.model.impl.OrderDao;
import com.java.tutorial.service.Service;

import java.util.List;

public class OrderService implements Service<Order> {
    private final Repository<Order> repository = new OrderDao();
    @Override
    public void create(Order entity) throws ServiceException {
        try {
            repository.insert(entity);
        } catch (DaoException e) {
            throw new ServiceException("order can't add");
        }
    }

    @Override
    public List<Order> readAll() throws ServiceException {
        try {
            return repository.select();
        } catch (DaoException e) {
            throw new ServiceException("order can't readAll");
        }
    }

    @Override
    public Order read(long id) throws ServiceException {
        try {
           return repository.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException("order can't add");
        }
    }

    @Override
    public void update(Order entity) throws ServiceException {
        try {
            repository.update(entity);
        } catch (DaoException e) {
            throw new ServiceException("order can't add");
        }

    }

    @Override
    public void delete(Order entity) throws ServiceException {
        try {
            repository.delete(entity);
        } catch (DaoException e) {
            throw new ServiceException("order can't add");
        }

    }

    @Override
    public void deleteById(long id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException("order can't deleteById");
        }
    }

    @Override
    public Order createByLogin(String login, String password) throws ServiceException {
        return null;
    }
}
