package com.java.tutorial.model.impl;

import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements Repository<Account> {

    private static final String INSERT = "INSERT INTO account (first_name,last_name,login,password,email,type) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE account SET first_name = ?,last_name = ? ,login = ? ,password = ? ,email= ? ,type = ?where id= ?";
    private static final String DELETE = "delete from account";
    private static final String DELETE_BY_ID = "DELETE FROM account where id=?";
    private static final String SELECT_BY_ID = "SELECT * FROM account WHERE id=?";
    private static final String SELECT_ALL = "SELECT * FROM account";
    private static final String SELECT_BY_LOGIN = "select * from account where login=? and password = ?";


    @Override
    public void insert(Account entity) throws DaoException {

        try{
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setString(6,entity.getType().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("account can't insert");
        }
    }

    @Override
    public List<Account> select() throws DaoException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setFirstName(resultSet.getString("first_name"));
                account.setLastName(resultSet.getString("last_name"));
                account.setPassword(resultSet.getString("password"));
                account.setLogin(resultSet.getString("login"));
                account.setEmail(resultSet.getString("email"));
                account.setType(UserType.valueOf(resultSet.getString("type")));
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            throw new DaoException("account can't select");
        }
    }



    @Override
    public Account selectByLogin(String login, String password) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_LOGIN);
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                account.setFirstName(resultSet.getString("first_name"));
                account.setLastName(resultSet.getString("last_name"));
                account.setType(UserType.valueOf(resultSet.getString("type")));
                account.setEmail(resultSet.getString("email"));
                return account;
            }
        } catch (SQLException throwables) {
            throw new DaoException("account con't selected");
        }
        return null;
    }
    @Override
    public Account selectById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setFirstName(resultSet.getString("first_name"));
                account.setLastName(resultSet.getString("last_name"));
                account.setPassword(resultSet.getString("password"));
                account.setLogin(resultSet.getString("login"));
                account.setEmail(resultSet.getString("email"));
                account.setType(UserType.valueOf(resultSet.getString("type")));
                return account;
            }
        } catch (SQLException throwables) {
            throw new DaoException("account can't select_by_id");
        }
        return null;
    }



    @Override
    public boolean update(Account entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setString(6,entity.getType().toString());
            statement.setLong(7,entity.getId());
            int i = statement.executeUpdate();
            if (i==1){
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException("account can't update");
        }

        return false;
    }

    @Override
    public void delete(Account entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("account can't delete");
        }
    }

    @Override
    public void deleteById (long id) throws DaoException{
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("account can't delete id");
        }
    }

}
