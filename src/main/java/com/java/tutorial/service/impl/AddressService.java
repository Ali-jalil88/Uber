package com.java.tutorial.service.impl;

import com.java.tutorial.entities.Address;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.model.Repository;
import com.java.tutorial.model.impl.AddressDao;
import com.java.tutorial.service.Service;

import java.util.List;

public class AddressService implements Service<Address> {
    private final Repository<Address> repository = new AddressDao();
    @Override
    public void create(Address entity) throws ServiceException {
        try {
            repository.insert(entity);
        } catch (DaoException e) {
            throw new ServiceException(" address can't add ");
        }

    }

    @Override
    public List<Address> readAll() throws ServiceException {
        try {
            return repository.select();
        } catch (DaoException e) {
            throw new ServiceException("address can't readAll");
        }
    }

    @Override
    public Address read(long id) throws ServiceException {
        try {
           return repository.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException("address can't add");
        }

    }

    @Override
    public void update(Address entity) throws ServiceException {
        try {
            repository.update(entity);
        } catch (DaoException e) {
            throw new ServiceException("address can't add");
        }

    }

    @Override
    public void delete(Address entity) throws ServiceException {
        try {
            repository.delete(entity);
        } catch (DaoException e) {
            throw new ServiceException("address can't add");
        }

    }

    @Override
    public void deleteById(long id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException("address can deleteById");
        }
    }

    @Override
    public List<Address> createByLogin(String login, String password) throws ServiceException {
        return null;
    }
}
