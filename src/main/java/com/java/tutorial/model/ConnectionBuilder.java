package com.java.tutorial.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    private ConnectionBuilder(){
    }
    private static Connection connection = null ;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/uber",
                    "postgres",
                    "swrali88");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }
}
