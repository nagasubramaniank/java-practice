package com.jsanghvi.patterns.structural.adapter;

class EmployeeLdap {
    private final String fullName;
    private final int id;
    private final String emailAddress;

    public EmployeeLdap(String fullName, int id, String emailAddress) {
        this.fullName = fullName;
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
