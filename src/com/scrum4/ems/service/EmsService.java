package com.scrum4.ems.service;

import com.scrum4.ems.employee.Employee;
import com.scrum4.ems.employee.EmployeeAddressDetails;
import com.scrum4.ems.employee.EmployeeInfo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmsService {

    private LinkedList<Employee> employeeList;
    public Employee emp = new Employee();

    public EmsService() {
        this.employeeList = new LinkedList<>(); // Use LinkedList here
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Method to update an employee
    
        public void updateEmployee(int employeeId) {
            // Assuming 'service' is an instance of your service class
            Employee employee = emp.getEmployeeById(employeeId);
    
            if (employee != null) {
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
            } else {
                System.out.println("Employee not found.");
            }
        }
    
    

 // Method to update employee info
    private void updateEmployeeInfo(EmployeeInfo info) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose what you want to update:");
        System.out.println("1. Employee name");
        System.out.println("2. Employee salary");
        System.out.println("3. Employee age");
        System.out.println("4. Employee current company");
        System.out.println("5. Employee previous company");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter employee name:");
                info.setName(scanner.nextLine());
                break;
            case 2:
                System.out.println("Enter employee salary:");
                info.setSalary(scanner.nextLine());
                break;
            case 3:
                System.out.println("Enter employee age:");
                info.setAge(scanner.nextInt());
                break;
            case 4:
                scanner.nextLine(); // Consume newline
                System.out.println("Enter employee current company:");
                info.setCurrentCompany(scanner.nextLine());
                break;
            case 5:
                scanner.nextLine(); // Consume newline
                System.out.println("Enter employee previous company:");
                info.setPrevCompany(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Method to update employee address details
    private void updateEmployeeAddress(EmployeeAddressDetails address) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose what you want to update in the address:");
        System.out.println("1. Door number");
        System.out.println("2. Street");
        System.out.println("3. City");
        System.out.println("4. State");
        System.out.println("5. Country");
        System.out.println("6. Pin code");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter door number:");
                address.setDoorNo(scanner.nextInt());
                break;
            case 2:
                scanner.nextLine(); // Consume newline
                System.out.println("Enter street:");
                address.setStreet(scanner.nextLine());
                break;
            case 3:
                System.out.println("Enter city:");
                address.setCity(scanner.nextLine());
                break;
            case 4:
                System.out.println("Enter state:");
                address.setState(scanner.nextLine());
                break;
            case 5:
                System.out.println("Enter country:");
                address.setCountry(scanner.nextLine());
                break;
            case 6:
                System.out.println("Enter pin code:");
                address.setPinCode(scanner.nextInt());
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
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
    public LinkedList<Employee> viewAllEmployees() {
        return employeeList;
    }

    // Method to sort employees by name
    public void sortEmployeesByName() {
        Collections.sort(employeeList, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    }
}
