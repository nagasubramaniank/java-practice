package com.jsanghvi.patterns.creational.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
    public static void main(String args[]) {
        DbSingleton database = DbSingleton.getInstance();

        long time = System.currentTimeMillis();
        Connection connection = database.getConnection();
        long duration = System.currentTimeMillis() - time;

        System.out.println("Duration for creating database connection: " + duration + " ms.");

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Address(id INT, streetName VARCHAR(32), city VARCHAR(32))");
            System.out.println("Table 'Address' created.");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        time = System.currentTimeMillis();
        database.getConnection();
        duration = System.currentTimeMillis() - time;

        System.out.println("Duration for creating database connection: " + duration + " ms.");
    }
}
