package com.jsanghvi.patterns.structural.bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class BridgeEverydayDemo {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            String databaseUrl = "jdbc:derby:memory:codejava/webdb;create=true";
            Connection connection = DriverManager.getConnection(databaseUrl);
            Statement statement = connection.createStatement();

            // This client can work with any database that has JDBC driver.
            statement.executeUpdate("CREATE TABLE Address (id INT, streetName VARCHAR(20), city VARCHAR(20))");
            System.out.println("Table 'Address' created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
