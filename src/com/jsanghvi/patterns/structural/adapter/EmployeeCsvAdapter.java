package com.jsanghvi.patterns.structural.adapter;

public class EmployeeCsvAdapter implements Employee {
    private final EmployeeCsv employeeCsv;

    EmployeeCsvAdapter(EmployeeCsv employeeCsv) {
        this.employeeCsv = employeeCsv;
    }

    @Override
    public String getId() {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            return properties[0];
        }

        return null;
    }

    @Override
    public void setId(String id) {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            properties[0] = id;
            employeeCsv.setValue(String.join(", ", properties));
        }
    }

    @Override
    public String getFirstName() {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            return properties[1];
        }

        return null;
    }

    @Override
    public void setFirstName(String firstName) {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            properties[1] = firstName;
            employeeCsv.setValue(String.join(", ", properties));
        }
    }

    @Override
    public String getLastName() {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            return properties[2];
        }

        return null;
    }

    @Override
    public void setLastName(String lastName) {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            properties[2] = lastName;
            employeeCsv.setValue(String.join(", ", properties));
        }
    }

    @Override
    public String getEmail() {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            return properties[3];
        }

        return null;
    }

    @Override
    public void setEmail(String email) {
        String[] properties = employeeCsv.getValue().split(", ");
        if (properties.length >= 4) {
            properties[3] = email;
            employeeCsv.setValue(String.join(", ", properties));
        }
    }
}
