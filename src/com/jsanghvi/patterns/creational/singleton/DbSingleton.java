package com.jsanghvi.patterns.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    private static DbSingleton instance = null;
    private Connection connection = null;

    private DbSingleton() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            synchronized (DbSingleton.class) {
                if (connection == null) {
                    try {
                        String databaseUrl = "jdbc:derby:memory:codejava/webdb;create=true";
                        connection = DriverManager.getConnection(databaseUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return connection;
    }
}
