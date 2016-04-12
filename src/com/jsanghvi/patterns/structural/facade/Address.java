package com.jsanghvi.patterns.structural.facade;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Address {
    private final int id;
    private final String streetName;
    private final String city;

    public Address(int id, String streetName, String city) {
        this.id = id;
        this.streetName = streetName;
        this.city = city;
    }

    public static String getTableName() {
        return "Address";
    }

    public static List<Map.Entry<String, String>> getTableFields() {
        List<Map.Entry<String, String>> tableFields = new ArrayList<>();

        tableFields.add(new AbstractMap.SimpleEntry<>("id", "INTEGER"));
        tableFields.add(new AbstractMap.SimpleEntry<>("streetName", "VARCHAR(32)"));
        tableFields.add(new AbstractMap.SimpleEntry<>("city", "VARCHAR(32)"));

        return tableFields;
    }

    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Street name: '" + streetName + "', City: '" + city + "'.";
    }
}
