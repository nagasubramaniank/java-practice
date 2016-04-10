package com.jsanghvi.patterns.structural.adapter;

class EmployeeLdap {
    private String fullName;
    private int id;
    private String emailAddress;

    public EmployeeLdap(String fullName, int id, String emailAddress) {
        this.fullName = fullName;
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
