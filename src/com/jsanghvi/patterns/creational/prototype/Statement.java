package com.jsanghvi.patterns.creational.prototype;

import java.util.List;

public class Statement implements Cloneable {
    private final String query;
    private final List<String> parameters;
    private final Record record;

    public Statement(String query, List<String> parameters, Record record) {
        this.query = query;
        this.parameters = parameters;
        this.record = record;
    }

    @Override
    public Statement clone() {
        try {
            // Shallow copy.
            return (Statement) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getQuery() {
        return this.query;
    }

    public List<String> getParameters() {
        return this.parameters;
    }

    public Record getRecord() {
        return this.record;
    }
}
