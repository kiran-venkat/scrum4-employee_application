package com.scrum4.ems.employee;

public class EmployeeAddressDetails {
	private int doorNo;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pinCode;

	public EmployeeAddressDetails() {

	}

	// Constructor
	public EmployeeAddressDetails(int doorNo, String street, String city, String state, String country, int pinCode) {
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	// Getter methods
	public int getDoorNo() {
		return doorNo;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public int getPinCode() {
		return pinCode;
	}

	// Setter methods
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
