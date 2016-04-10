package com.jsanghvi.patterns.structural.adapter;

class EmployeeLdapAdapter implements Employee {
    private final EmployeeLdap employeeLdap;

    EmployeeLdapAdapter(EmployeeLdap employeeLdap) {
        this.employeeLdap = employeeLdap;
    }

    @Override
    public String getId() {
        return String.valueOf(employeeLdap.getId());
    }

    @Override
    public void setId(String id) {
        employeeLdap.setId(Integer.parseInt(id));
    }

    @Override
    public String getFirstName() {
        return employeeLdap.getFullName().substring(0, employeeLdap.getFullName().indexOf(' '));
    }

    @Override
    public void setFirstName(String firstName) {
        employeeLdap.setFullName(
                firstName + employeeLdap.getFullName().substring(employeeLdap.getFullName().indexOf(' ')));
    }

    @Override
    public String getLastName() {
        return employeeLdap.getFullName().substring(employeeLdap.getFullName().lastIndexOf(' ') + 1);
    }

    @Override
    public void setLastName(String lastName) {
        employeeLdap.setFullName(
                employeeLdap.getFullName().substring(0, employeeLdap.getFullName().lastIndexOf(' ') + 1) + lastName);
    }

    @Override
    public String getEmail() {
        return employeeLdap.getEmailAddress();
    }

    @Override
    public void setEmail(String email) {
        employeeLdap.setEmailAddress(email);
    }
}
