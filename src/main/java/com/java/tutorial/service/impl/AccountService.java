package com.java.tutorial.service.impl;

import com.java.tutorial.entities.Account;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.model.Repository;
import com.java.tutorial.model.impl.AccountDao;
import com.java.tutorial.service.Service;

import java.util.List;

public class AccountService implements Service<Account> {
    private final Repository<Account> repository = new AccountDao();
    @Override
    public void create(Account entity) throws ServiceException {
        try {
            repository.insert(entity);
        } catch (DaoException e) {
            throw new ServiceException("account can't add");
        }
    }
    @Override
    public Account createByLogin(String login, String password) throws ServiceException {
        try {
                return repository.selectByLogin(login, password);
        } catch (DaoException e) {
            throw new ServiceException("account can't find");
        }
    }


    @Override
    public Account read(long id) throws ServiceException {
        try {
            return repository.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException("account can't add");
        }
    }

    @Override
    public List<Account> readAll() throws ServiceException {
        try {
            return repository.select();
        } catch (DaoException e) {
            throw new ServiceException("account can't readAll");
        }
    }

    @Override
    public void update(Account entity) throws ServiceException {
        try {
            repository.update(entity);
        } catch (DaoException e) {
            throw new ServiceException("account can't add");
        }
    }

    @Override
    public void delete(Account entity) throws ServiceException {
        try {
            repository.delete(entity);
        } catch (DaoException e) {
            throw new ServiceException("account can't add");
        }
    }

    @Override
    public void deleteById(long id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException("account can deleteById");
        }
    }


}
