package com.jsanghvi.patterns.structural.adapter;

import java.util.List;

class AdapterDemo {
    public static void main(String[] args) {
        EmployeeClient employeeClient = new EmployeeClient();
        List<Employee> employees = employeeClient.getEmployees();
        employees.forEach(employee -> System.out.println("ID: " + employee.getId() + ", First name: "
                + employee.getFirstName() + ", Last name: " + employee.getLastName() + ", Email address: "
                + employee.getEmail() + "."));
    }
}
