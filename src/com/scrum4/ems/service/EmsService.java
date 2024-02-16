package com.scrum4.ems.service;

import com.scrum4.ems.employee.EmployeeInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmsService {

    private List<EmployeeInfo> employeeList;

    public EmsService() {
        this.employeeList = new ArrayList<>();
    }

    // Method to add an employee
    public void addEmployee(EmployeeInfo employee) {
        employeeList.add(employee);
    }

    // Method to update an employee
    public void updateEmployee(EmployeeInfo updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            EmployeeInfo employee = employeeList.get(i);
            if (employee.getId() == updatedEmployee.getId()) {
                employeeList.set(i, updatedEmployee);
                break;
            }
        }
    }

    // Method to view an employee by ID
    public EmployeeInfo viewEmployee(int employeeId) {
        for (EmployeeInfo employee : employeeList) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    // Method to view all employees
    public List<EmployeeInfo> viewAllEmployees() {
        return employeeList;
    }

    // Method to sort employees by name
    public void sortEmployeesByName() {
        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    }
}
