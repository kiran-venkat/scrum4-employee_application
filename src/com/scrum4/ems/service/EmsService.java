package com.scrum4.ems.service;

import com.scrum4.ems.employee.Employee;
import com.scrum4.ems.employee.EmployeeAddressDetails;
import com.scrum4.ems.employee.EmployeeInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class EmsService {

    private Map<Integer,Employee> employeeList;

    public EmsService() {
        this.employeeList = new HashMap<>(); // Use LinkedList here
    }

    // Method to add an employee
    public void addEmployee(Employee employee,EmployeeInfo empInfo) {
        employeeList.put(empInfo.getId(),employee);
    }

    // Method to update an employee
    public void updateEmployee(Employee employee) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose what you want to update:");
        System.out.println("1. Employee info");
        System.out.println("2. Address details");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                updateEmployeeInfo(employee.getInfo());
                break;
            case 2:
                updateEmployeeAddress(employee.getAddress());
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Method to update employee info
    private void updateEmployeeInfo(EmployeeInfo info) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee name:");
        info.setName(scanner.nextLine());

        System.out.println("Enter employee salary:");
        info.setSalary(scanner.nextLine());

        System.out.println("Enter employee age:");
        info.setAge(scanner.nextInt());

        scanner.nextLine(); // Consume newline
        System.out.println("Enter employee current company:");
        info.setCurrentCompany(scanner.nextLine());

        System.out.println("Enter employee previous company:");
        info.setPrevCompany(scanner.nextLine());
        
        scanner.close();
    }

    // Method to update employee address details
    private void updateEmployeeAddress(EmployeeAddressDetails address) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter door number:");
        address.setDoorNo(scanner.nextInt());

        scanner.nextLine(); // Consume newline
        System.out.println("Enter street:");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter city:");
        address.setCity(scanner.nextLine());

        System.out.println("Enter state:");
        address.setState(scanner.nextLine());

        System.out.println("Enter country:");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter pin code:");
        address.setPinCode(scanner.nextInt());
        
        scanner.close();
    }

    // Method to view an employee by ID
    public Employee viewEmployee(int employeeId) {
        for (Integer employee : employeeList.keySet()) {
        	Employee emp=new Employee();
        	 emp=employeeList.get(employee);
            if (emp.getId() == employeeId) {
                return emp;
            }
        }
        return null; // Employee not found
    }

    // Method to view all employees
    public Map<Integer,Employee> viewAllEmployees() {
        return employeeList;
    }

    // Method to sort employees by name
    public void sortEmployeesByName() {
       // Collections.sort(employeeList, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    }
}
