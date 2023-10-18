package org.caselab.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection{
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connection = null;
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/jdbc_test";
    private static final String USER = "jdbc_test";
    private static final String PASS = "+bG.h@h*5lo>03yh*7(A";
    private PostgresConnection(){};
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }


    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
