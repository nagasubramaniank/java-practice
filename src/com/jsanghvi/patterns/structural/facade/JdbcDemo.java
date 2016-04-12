package com.jsanghvi.patterns.structural.facade;

import com.jsanghvi.patterns.creational.singleton.DbSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JdbcDemo {
    public static void main(String[] args) {
        DbSingleton db = DbSingleton.getInstance();

        try {
            Connection connection = db.getConnection();

            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Address (id INTEGER, streetName VARCHAR(32), city VARCHAR(32))");
            System.out.println("Table 'Address' created.");
            statement.close();

            statement = connection.createStatement();
            int count = statement.executeUpdate(
                    "INSERT INTO Address (id, streetName, city) VALUES (1, '1234 Some street', 'Layton')");
            System.out.println(count + " record(s) inserted.");
            statement.close();

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Address");

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3));
            }
            resultSet.close();
            statement.close();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
