package com.scrum4.ems.employee;

public class EmployeeInfo {
    private int id;
    private String name;
    private String salary; 
    private int age;
    private String currentCompany;  
    private String prevCompany;  
    
    // Constructor
    public EmployeeInfo(int id, String name, String salary, int age, String currentCompany, String prevCompany) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.currentCompany = currentCompany;
        this.prevCompany = prevCompany;
    }
    

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getPrevCompany() {
        return prevCompany;
    }

    public void setPrevCompany(String prevCompany) {
        this.prevCompany = prevCompany;
    }
}
