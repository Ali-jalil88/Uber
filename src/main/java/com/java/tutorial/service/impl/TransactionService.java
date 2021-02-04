package com.java.tutorial.service.impl;

import com.java.tutorial.entities.Transaction;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.model.Repository;
import com.java.tutorial.model.impl.TransactionDao;
import com.java.tutorial.service.Service;

import java.util.List;

public class TransactionService implements Service<Transaction> {
    private final Repository<Transaction> repository = new TransactionDao();
    @Override
    public void create(Transaction entity) throws ServiceException {
        try {
            repository.insert(entity);
        } catch (DaoException e) {
            throw new ServiceException("transaction can't add");
        }

    }

    @Override
    public List<Transaction> readAll() throws ServiceException {
        try {
            return repository.select();
        } catch (DaoException e) {
            throw new ServiceException("transaction can't readAll");
        }
    }

    @Override
    public Transaction read(long id) throws ServiceException {
        try {
           return repository.selectById(id);
        } catch (DaoException e) {
            throw new ServiceException("transaction can't add");
        }
    }

    @Override
    public void update(Transaction entity) throws ServiceException {
        try {
            repository.update(entity);
        } catch (DaoException e) {
            throw new ServiceException("transaction can't add");
        }

    }

    @Override
    public void delete(Transaction entity) throws ServiceException {
        try {
            repository.delete(entity);
        } catch (DaoException e) {
            throw new ServiceException("transaction can't add");
        }
    }

    @Override
    public void deleteById(long id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException("transaction can't deleteById");
        }
    }

    @Override
    public Transaction createByLogin(String login, String password) throws ServiceException {
        return null;
    }
}
