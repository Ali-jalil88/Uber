package com.java.tutorial.model.impl;

import com.java.tutorial.entities.StatusTransaction;
import com.java.tutorial.entities.Transaction;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao implements Repository<Transaction> {
    private static final String INSERT = "insert into transaction (order_id,price,pay_date,status) values (?,?,?,?)";
    private static final String UPDATE = "update transaction set order_id = ?,price = ? , pay_date =?,status = ? where id =?";
    private static final String DELETE = "delete from  transaction ";
    private static final String DELETE_BY_ID = "delete from transaction where id=?";
    private static final String SELECT = "SELECT * FROM transaction";
    private static final String SELECT_BY_ID = "SELECT * FROM transaction WHERE id =?";

    @Override
    public void insert(Transaction entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1,entity.getOrderId());
            statement.setDouble(2,entity.getPrice());
            statement.setString(3,entity.getPayDate());
            statement.setString(4, String.valueOf(entity.getStatus()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("transaction can't insert");
        }
    }

    @Override
    public List<Transaction> select() throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            List<Transaction> transactions = new ArrayList<>();
            while (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setPayDate(resultSet.getString("pay_date"));
                transaction.setOrderId(resultSet.getInt("order_id"));
                transaction.setPrice(resultSet.getDouble("price"));
                transaction.setStatus(StatusTransaction.valueOf(resultSet.getString("status")));
                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            throw new DaoException("transaction can't select");
        }
    }

    @Override
    public Transaction selectById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getLong("id"));
                transaction.setPayDate(resultSet.getString("pay_date"));
                transaction.setOrderId(resultSet.getInt("order_id"));
                transaction.setPrice(resultSet.getDouble("price"));
                transaction.setStatus(StatusTransaction.valueOf(resultSet.getString("status")));
                return transaction;
            }
        } catch (SQLException throwables) {
            throw new DaoException("transaction can't select_by_id");
        }
        return null;
    }

    @Override
    public Transaction selectByLogin(String login, String password) throws DaoException {
        return null;
    }

    @Override
    public boolean update(Transaction entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1,entity.getOrderId());
            statement.setDouble(2,entity.getPrice());
            statement.setString(3,entity.getPayDate());
            statement.setString(4, String.valueOf(entity.getStatus()));
            statement.setLong(5,entity.getId());
           int i =  statement.executeUpdate();
           if (i == 1){
               return true;
           }
        } catch (SQLException e) {
            throw new DaoException("transaction can't update");
        }
        return false;
    }

    @Override
    public void delete(Transaction entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("transaction can't delete");
        }
    }

    @Override
    public void deleteById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("transaction can't delete id");
        }
    }
}
