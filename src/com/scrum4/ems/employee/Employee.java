package com.scrum4.ems.employee;

public class Employee {
    private EmployeeInfo info;
    private EmployeeAddressDetails address;

    // Constructor
    public Employee(EmployeeInfo info, EmployeeAddressDetails address) {
        this.info = info;
        this.address = address;
    }

    public Employee(){
        this.info = info;
        this.address = address;
    }

    public EmployeeInfo getInfo() {
        return info;
    }

    public EmployeeAddressDetails getAddress() {
        return address;
    }

    
    // Getter and Setter methods for EmployeeInfo
    public int getId() {
        return info.getId();
    }

    public void setId(int id) {
        info.setId(id);
    }

    public String getName() {
        return info.getName();
    }

    public void setName(String name) {
        info.setName(name);
    }

    public String getSalary() {
        return info.getSalary();
    }

    public void setSalary(String salary) {
        info.setSalary(salary);
    }

    public int getAge() {
        return info.getAge();
    }

    public void setAge(int age) {
        info.setAge(age);
    }

    public String getCurrentCompany() {
        return info.getCurrentCompany();
    }

    public void setCurrentCompany(String currentCompany) {
        info.setCurrentCompany(currentCompany);
    }

    public String getPrevCompany() {
        return info.getPrevCompany();
    }

    public void setPrevCompany(String prevCompany) {
        info.setPrevCompany(prevCompany);
    }

    // Getter and Setter methods for EmployeeAddressDetails
    public int getDoorNo() {
        return address.getDoorNo();
    }

    public void setDoorNo(int doorNo) {
        address.setDoorNo(doorNo);
    }

    public String getStreet() {
        return address.getStreet();
    }

    public void setStreet(String street) {
        address.setStreet(street);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public String getState() {
        return address.getState();
    }

    public void setState(String state) {
        address.setState(state);
    }

    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public int getPinCode() {
        return address.getPinCode();
    }

    public void setPinCode(int pinCode) {
        address.setPinCode(pinCode);
    }

    public Employee getEmployeeById(int employeeId) {
        if (this.info.getId() == employeeId) {
            return this;
        } else {
            return null;
        }
    }
}
