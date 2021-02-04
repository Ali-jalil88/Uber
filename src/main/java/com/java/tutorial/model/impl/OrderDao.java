package com.java.tutorial.model.impl;

import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.Status;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Repository<Order> {
    private static final String INSERT = "insert into \"order\" (from_id,to_id,status,client_id,taxi_id, order_date) values (?,?,?,?,?,?)";
    private static final String UPDATE = "update \"order\" set from_id = ?,to_id = ? ,status = ? ,client_id = ? ,taxi_id= ?,order_date =? where id =?";
    private static final String DELETE = "delete from \"order\"";
    private static final String DELETE_BY_ID = "delete from \"order\" where id=?";
    private static final String SELECT ="SELECT * FROM \"order\"";
    private static final String SELECT_BY_ID = "SELECT * FROM \"order\" WHERE id = ?";
    @Override
    public void insert(Order entity) throws DaoException {
        try( PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1,entity.getFromId());
            statement.setInt(2,entity.getToId());
            statement.setString(3, String.valueOf(entity.getStatus()));
            statement.setInt(4,entity.getClientId());
            statement.setInt(5,entity.getTaxiId());
            statement.setString(6,entity.getOrderDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("order can't insert");
        }
    }

    @Override
    public List<Order> select() throws DaoException {

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setClientId(resultSet.getInt("client_id"));
                order.setTaxiId(resultSet.getInt("taxi_id"));
                order.setFromId(resultSet.getInt("from_id"));
                order.setToId(resultSet.getInt("to_id"));
                order.setOrderDate(resultSet.getString("order_date"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new DaoException("order can't select");
        }
    }

    @Override
    public Order selectById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setClientId(resultSet.getInt("client_id"));
                order.setTaxiId(resultSet.getInt("taxi_id"));
                order.setFromId(resultSet.getInt("from_id"));
                order.setToId(resultSet.getInt("to_id"));
                order.setOrderDate(resultSet.getString("order_date"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                return order;

            }
        } catch (SQLException throwables) {
            throw new DaoException("order can't select_by_id");
        }
        return null;
    }

    @Override
    public Order selectByLogin(String login, String password) throws DaoException {
        return null;
    }

    @Override
    public boolean update(Order entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(1,entity.getFromId());
            statement.setInt(2,entity.getToId());
            statement.setString(3, String.valueOf(entity.getStatus()));
            statement.setInt(4,entity.getClientId());
            statement.setInt(5,entity.getTaxiId());
            statement.setString(6,entity.getOrderDate());
            statement.setLong(7,entity.getId());
            int i = statement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException("order can't update");
        }

        return false;
    }

    @Override
    public void delete(Order entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("order can't delete");
        }

    }

    @Override
    public void deleteById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("order can't delete id");
        }
    }
}
