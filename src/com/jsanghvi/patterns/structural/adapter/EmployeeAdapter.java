package com.jsanghvi.patterns.structural.adapter;

import java.util.StringTokenizer;

class EmployeeAdapter implements Employee {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;

    EmployeeAdapter(EmployeeCsv employeeCsv) {
        // Skip 'id' property of employeeCsv. We can extract it from 'value' property.

        StringTokenizer tokenizer = new StringTokenizer(employeeCsv.getValue(), ",");
        boolean isValid = (tokenizer.countTokens() >= 4);

        id = isValid ? tokenizer.nextToken().trim() : null;
        firstName = isValid ? tokenizer.nextToken().trim() : null;
        lastName = isValid ? tokenizer.nextToken().trim() : null;
        email = isValid ? tokenizer.nextToken().trim() : null;
    }

    EmployeeAdapter(EmployeeLdap employeeLdap) {
        id = String.valueOf(employeeLdap.getId());
        firstName = employeeLdap.getFullName().substring(0, employeeLdap.getFullName().indexOf(' '));
        lastName = employeeLdap.getFullName().substring(employeeLdap.getFullName().lastIndexOf(' ') + 1);
        email = employeeLdap.getEmailAddress();
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
