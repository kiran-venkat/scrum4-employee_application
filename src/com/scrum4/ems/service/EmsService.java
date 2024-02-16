package com.scrum4.ems.service;

import com.scrum4.ems.employee.Employee;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmsService {

    private List<Employee> employeeList;

    public EmsService() {
        this.employeeList = new LinkedList<>(); // Use LinkedList here
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Method to update an employee
    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId() == updatedEmployee.getId()) {
                employeeList.set(i, updatedEmployee);
                break;
            }
        }
    }

    // Method to view an employee by ID
    public Employee viewEmployee(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    // Method to view all employees
    public List<Employee> viewAllEmployees() {
        return employeeList;
    }

    // Method to sort employees by name
    public void sortEmployeesByName() {
        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    }
}
