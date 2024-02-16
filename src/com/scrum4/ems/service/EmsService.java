package com.scrum4.ems.service;

import com.scrum4.ems.employee.Employee;
import com.scrum4.ems.employee.EmployeeAddressDetails;
import com.scrum4.ems.employee.EmployeeInfo;

import java.util.Collections;
//import java.util.HashMap;
import java.util.LinkedList;
//import java.util.Map;
import java.util.Scanner;

public class EmsService {

//<<<<<<< HEAD
//    private Map<Integer,Employee> employeeList;
//=======
    private LinkedList<Employee> employeeList;
    public Employee emp = new Employee();
//>>>>>>> 2f6082e790367ba51e2cb004cbf72c6b05cc0678

    public EmsService() {
        this.employeeList = new LinkedList<>(); // Use LinkedList here

        // Adding dummy employees
        addDummyEmployees();
    }

    // Method to add dummy employees
    private void addDummyEmployees() {
        // Employee 1
        EmployeeInfo info1 = new EmployeeInfo(1, "John Doe", "5000", 30, "ABC Corp", "XYZ Ltd");
        EmployeeAddressDetails address1 = new EmployeeAddressDetails(123, "Main St", "City", "State", "Country", 12345);
        Employee employee1 = new Employee(info1, address1);
        employeeList.add(employee1);

        // Employee 2
        EmployeeInfo info2 = new EmployeeInfo(2, "Jane Smith", "6000", 35, "DEF Corp", "PQR Ltd");
        EmployeeAddressDetails address2 = new EmployeeAddressDetails(456, "Oak St", "City", "State", "Country", 67890);
        Employee employee2 = new Employee(info2, address2);
        employeeList.add(employee2);

        // Add more dummy employees as needed
    }

    // Method to add an employee
//<<<<<<< HEAD
//    public void addEmployee(Employee employee,EmployeeInfo empInfo) {
//        employeeList.put(empInfo.getId(),employee);
//=======
    public void addEmployee(Employee employee) {
        Employee employee1 = getEmployeeDetailsFromUserInput();
        employeeList.add(employee1);
    }
    Scanner scanner = new Scanner(System.in);

    // Method to get employee details from user input
    public Employee getEmployeeDetailsFromUserInput() {
        System.out.println("Enter employee details:");

        // EmployeeInfo details
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        String salary = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee current company: ");
        String currentCompany = scanner.nextLine();
        System.out.print("Enter employee previous company: ");
        String prevCompany = scanner.nextLine();

        EmployeeInfo info = new EmployeeInfo(id, name, salary, age, currentCompany, prevCompany);

        // EmployeeAddressDetails details
        System.out.print("Enter door number: ");
        int doorNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        System.out.print("Enter pin code: ");
        int pinCode = scanner.nextInt();

        EmployeeAddressDetails address = new EmployeeAddressDetails(doorNo, street, city, state, country, pinCode);

        // Create Employee object and add to the list
        Employee employee = new Employee(info, address);
        return employee;
//>>>>>>> 2f6082e790367ba51e2cb004cbf72c6b05cc0678
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
        for (Employee employee : employeeList){
//        	Employee emp=new Employee();
//        	 emp=employeeList.get(employee);
            if (employee.getId() == employeeId) {
                return emp;
            }
        }
        return null; // Employee not found
    }

    // Method to view all employees
//<<<<<<< HEAD
   // public Map<Integer,Employee> viewAllEmployees() {
//=======
    public LinkedList<Employee> viewAllEmployees() {
//>>>>>>> 2f6082e790367ba51e2cb004cbf72c6b05cc0678
        return employeeList;
    }

    // Method to sort employees by name
    public void sortEmployeesByName() {
       // Collections.sort(employeeList, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    }
}
