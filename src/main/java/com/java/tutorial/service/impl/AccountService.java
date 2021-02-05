package com.java.tutorial.service.impl;

import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Address;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.exception.ServiceException;
import com.java.tutorial.model.Repository;
import com.java.tutorial.model.impl.AccountDao;
import com.java.tutorial.model.impl.AddressDao;
import com.java.tutorial.service.Service;

import java.util.ArrayList;
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
    public List<Account> createByLogin(String login, String password) throws ServiceException {
        try {
            List<Account> accountList = new ArrayList<>();
            accountList.addAll(repository.select());
            Account account = repository.selectByLogin(login, password);
            return accountListSorting(accountList, account);
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

    public List<Account> accountListSorting(List<Account> accountList, Account account) {
        if (account.getType() == UserType.ADMIN || account.getType() == UserType.CLIENT) {
            return taxiList(accountList);
        } else {
            return clientList(accountList);
        }
    }

    public List<Account> taxiList(List<Account> accountList) {
        List<Account> taxiList = new ArrayList<>();
        for (Account account : accountList) {
            if (account.getType() == UserType.TAXI) taxiList.add(account);
        }
        return taxiList;
    }

    public List<Account> clientList(List<Account> accountList) {
        List<Account> clientList = new ArrayList<>();
        for (Account account : accountList)
            if (account.getType() == UserType.CLIENT) clientList.add(account);
        return clientList;
    }
}
