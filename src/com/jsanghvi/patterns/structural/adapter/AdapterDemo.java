package com.jsanghvi.patterns.structural.adapter;

import java.util.List;

class AdapterDemo {
    public static void main(String[] args) {
        EmployeeClient employeeClient = new EmployeeClient();
        List<Employee> employees = employeeClient.getEmployees();

        // Print details of all employees.
        employees.forEach(AdapterDemo::printEmployeeDetails);

        // Change attributes of all employees.
        employees.forEach(employee -> {
            employee.setId("298");
            employee.setFirstName("Hiren");
            employee.setLastName("Mehta");
            employee.setEmail("hmehta@company.com");
        });

        // Print details of all employees again.
        employees.forEach(AdapterDemo::printEmployeeDetails);
    }

    private static void printEmployeeDetails(Employee employee) {
        System.out.println("ID: " + employee.getId() + ", First name: " + employee.getFirstName() + ", Last name: "
                + employee.getLastName() + ", Email address: " + employee.getEmail() + ".");
    }
}
