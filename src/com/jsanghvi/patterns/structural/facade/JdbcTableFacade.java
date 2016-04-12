package com.jsanghvi.patterns.structural.facade;

import com.jsanghvi.patterns.creational.singleton.DbSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class JdbcTableFacade {
    private final String tableName;
    private final List<Map.Entry<String, String>> tableFields;
    private final Connection connection;

    public JdbcTableFacade(String tableName, List<Map.Entry<String, String>> tableFields) {
        this.tableName = tableName;
        this.tableFields = tableFields;

        DbSingleton db = DbSingleton.getInstance();
        connection = db.getConnection();
        createTable();
    }

    private void createTable() {
        try (Statement statement = connection.createStatement()) {

            String tableFieldString = tableFields.stream().map(entry -> entry.getKey() + " " + entry.getValue())
                    .collect(Collectors.joining(", "));
            statement.executeUpdate("CREATE TABLE " + tableName + " (" + tableFieldString + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Address address) {
        int count = 0;

        try (Statement statement = connection.createStatement()) {

            String tableFieldString = tableFields.stream().map(Map.Entry::getKey)
                    .collect(Collectors.joining(", "));

            List<String> valueList = new ArrayList<>();
            valueList.add(String.valueOf(address.getId()));
            valueList.add("'" + address.getStreetName() + "'");
            valueList.add("'" + address.getCity() + "'");
            String valueString = String.join(", ", valueList);

            statement.executeUpdate(
                    "INSERT INTO " + tableName + " (" + tableFieldString + ") VALUES (" + valueString + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Address")
        ) {
            while (resultSet.next()) {
                addresses.add(new Address(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    }
}
