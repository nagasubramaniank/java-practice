package com.jsanghvi.patterns.structural.adapter;

class EmployeeDb implements Employee {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public EmployeeDb(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
