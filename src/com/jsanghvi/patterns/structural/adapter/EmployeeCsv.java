package com.jsanghvi.patterns.structural.adapter;

class EmployeeCsv {
    private final int id;
    private final String value;

    public EmployeeCsv(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
