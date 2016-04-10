package com.jsanghvi.patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

class EmployeeClient {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeClient() {
        EmployeeDb employeeDb = new EmployeeDb("147", "Jatin", "Sanghvi", "jsanghvi@company.com");
        employees.add(employeeDb);

        EmployeeLdap employeeLdap = new EmployeeLdap("Jatin Sanghvi", 147, "jsanghvi@company.com");
        employees.add(new EmployeeAdapter(employeeLdap));

        EmployeeCsv employeeCsv = new EmployeeCsv(147, "147, Jatin, Sanghvi, jsanghvi@company.com");
        employees.add(new EmployeeAdapter(employeeCsv));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
