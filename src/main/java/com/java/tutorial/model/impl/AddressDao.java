package com.java.tutorial.model.impl;

import com.java.tutorial.entities.Address;
import com.java.tutorial.exception.DaoException;
import com.java.tutorial.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements Repository<Address> {
    private static final String INSERT = "INSERT INTO address( name_street,number_street )VALUES (?,?)";
    private static final String UPDATE = "update address set name_street = ?,number_street = ? where id =?";
    private static final String DELETE = "delete from address";
    private static final String DELETE_BY_ID = "delete from address where id =?";
    private static final String SELECT = "SELECT * FROM address";
    private static final String SELECT_BY_ID = "SELECT * FROM address where id =?";
    @Override
    public void insert(Address entity) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1,entity.getNameStreet());
            statement.setInt(2,entity.getNumberStreet());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("address can't insert");
        }
    }

    @Override
    public List<Address> select() throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            List<Address> addresses = new ArrayList<>();
            while (resultSet.next()){
                Address address = new Address();
                address.setNameStreet(resultSet.getString("name_street"));
                address.setNumberStreet(resultSet.getInt("number_street"));
                address.setId(resultSet.getLong("id"));
                addresses.add(address);
            }
            return addresses;
        } catch (SQLException e) {
            throw new DaoException("address can't select");
        }
    }

    @Override
    public Address selectById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setNameStreet(resultSet.getString("name_street"));
                address.setNumberStreet(resultSet.getInt("number_street"));
                return address;
            }
        } catch (SQLException e) {
            throw new DaoException("address can't select_by_id");
        }
        return null;
    }

    @Override
    public Address selectByLogin(String login, String password) throws DaoException {
        return null;
    }

    @Override
    public boolean update(Address entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setInt(2,entity.getNumberStreet());
            statement.setString(1,entity.getNameStreet());
            statement.setLong(3,entity.getId());
            int i = statement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new DaoException("address can't update");
        }

        return false;
    }

    @Override
    public void delete(Address entity) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("address can't delete");
        }
    }

    @Override
    public void deleteById(long id) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("address can't deleteById");
        }
    }
}
