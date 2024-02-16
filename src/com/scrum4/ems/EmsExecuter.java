package com.scrum4.ems;

import java.util.*;
import com.scrum4.ems.data.admin.*;
import com.scrum4.ems.employee.*;
import com.scrum4.ems.exceptions.UnauthorizedException;
import com.scrum4.ems.service.EmsService;

public class EmsExecuter {
	public static void main(String[] args) {
		String adminName;
		String adminPassword;
		
		
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("Enter your name:");
			adminName = sc.next();

			System.out.println("Enter your password:");
			adminPassword = sc.next();

			try {
				AdminDetails detail = adminVerification(adminName, adminPassword);

				if (adminVerification(adminName, adminPassword) == null) {
					throw new UnauthorizedException("Unauthorized adminName and password");
				}
				EmsService service = new EmsService();
				EmployeeInfo empInfo = new EmployeeInfo();
				EmployeeAddressDetails empAddress = new EmployeeAddressDetails();
				boolean showChoice = true;
				while (showChoice) {
					System.out.println("1.Add Employee Details");
					System.out.println("2.Update Employee Details");
					System.out.println("3.View Employee Details");
					System.out.println("4.View All Employee Details");
					System.out.println("5.Sort Employee Details");
					System.out.println("6.Log out");
					System.out.println("Enter your Choice");
					int serviceChoice = sc.nextInt();
					switch (serviceChoice) {
					case 1:
						try {
							if (detail.getAdminRole() == "Admin_ALL") {
								Employee employee = new Employee(empInfo, empAddress);
								service.addEmployee(employee);
								break;
							} else {
								throw new UnauthorizedException("Access denied for this admin");
							}
						} catch (UnauthorizedException e) {
							System.out.println(e.getMessage());
							break;
						}

					case 2:
						try {
							if (detail.getAdminRole() == "Admin_ALL") {
								System.out.println("Enter the Employees ID to be updated");
								int employeeId = sc.nextInt();
								
								service.updateEmployee(employeeId);
								System.out.println("Update Successfully");

								break;
							} else {
								throw new UnauthorizedException("Access denied for this admin");
							}
						} catch (UnauthorizedException e) {
							System.out.println(e.getMessage());
							break;
						}

					case 3:
						System.out.println("Enter the Employees ID to be searched");
						int searchEmployeeID = sc.nextInt();
						Employee foundEmployee = service.viewEmployee(searchEmployeeID);

						if (foundEmployee != null) {
							System.out.println("Employee found!");
							System.out.println("Employee ID: " + foundEmployee.getInfo().getId());
							System.out.println("Employee Name: " + foundEmployee.getInfo().getName());
							System.out.println("Employee Salary: " + foundEmployee.getInfo().getSalary());
							System.out.println("Employee Age: " + foundEmployee.getInfo().getAge());
							System.out.println(
									"Employee Current Company: " + foundEmployee.getInfo().getCurrentCompany());
							System.out.println(
									"Employee Previous Company: " + foundEmployee.getInfo().getPrevCompany());
							System.out.println(
									"Employee Door No: " + foundEmployee.getAddress().getDoorNo());
							System.out.println(
									"Employee City: " + foundEmployee.getAddress().getCity());
							System.out.println(
									"Employee Country: " + foundEmployee.getAddress().getCountry());
							System.out.println(
									"Employee State: " + foundEmployee.getAddress().getState());
							System.out.println(
									"Employee Pincode: " + foundEmployee.getAddress().getPinCode());
							System.out.println(
									"Employee Street: " + foundEmployee.getAddress().getStreet());
							System.out.println(); // Add an empty line for better readability
						} else {
							System.out.println("Employee not found.");
						}
						break;

					case 4:
						LinkedList<Employee> employeeDetails = service.viewAllEmployees();

						// Check if the list is not empty
						if (!employeeDetails.isEmpty()) {
							// Iterate over the list and display details of each employee
							for (Employee employeeDet : employeeDetails) {
								System.out.println("Employee ID: " + employeeDet.getInfo().getId());
								System.out.println("Employee Name: " + employeeDet.getInfo().getName());
								System.out.println("Employee Salary: " + employeeDet.getInfo().getSalary());
								System.out.println("Employee Age: " + employeeDet.getInfo().getAge());
								System.out.println(
										"Employee Current Company: " + employeeDet.getInfo().getCurrentCompany());
								System.out.println(
										"Employee Previous Company: " + employeeDet.getInfo().getPrevCompany());
								System.out.println(
										"Employee Door No: " + employeeDet.getAddress().getDoorNo());
								System.out.println(
										"Employee City: " + employeeDet.getAddress().getCity());
								System.out.println(
										"Employee Country: " + employeeDet.getAddress().getCountry());
								System.out.println(
										"Employee State: " + employeeDet.getAddress().getState());
								System.out.println(
										"Employee Pincode: " + employeeDet.getAddress().getPinCode());
								System.out.println(
										"Employee Street: " + employeeDet.getAddress().getStreet());
								System.out.println(); // Add an empty line for better readability
							}
						} else {
							System.out.println("No employees found.");
						}
						break;

					case 5:
						try {
							if (detail.getAdminRole() == "Admin_ALL") {
								String input;

								System.out.println("Enter how to sort {Name/Id]");
								input = sc.next();
								if (input.equalsIgnoreCase("name"))
									service.sortEmployeesByName();
								else if (input.equalsIgnoreCase("ID"))
									service.sortEmployeesByID();
								else
									System.out.println("Invalid Choice");

								LinkedList<Employee> employeeDetails1 = service.viewAllEmployees();

								// Check if the list is not empty
								if (!employeeDetails1.isEmpty()) {
									// Iterate over the list and display details of each employee
									for (Employee employeeDet1 : employeeDetails1) {
										System.out.println("Employee ID: " + employeeDet1.getInfo().getId());
										System.out.println("Employee Name: " + employeeDet1.getInfo().getName());
										System.out.println("Employee Salary: " + employeeDet1.getInfo().getSalary());
										System.out.println("Employee Age: " + employeeDet1.getInfo().getAge());
										System.out.println(
												"Employee Current Company: " + employeeDet1.getInfo().getCurrentCompany());
										System.out.println(
												"Employee Previous Company: " + employeeDet1.getInfo().getPrevCompany());
										System.out.println(
												"Employee Door No: " + employeeDet1.getAddress().getDoorNo());
										System.out.println(
												"Employee City: " + employeeDet1.getAddress().getCity());
										System.out.println(
												"Employee Country: " + employeeDet1.getAddress().getCountry());
										System.out.println(
												"Employee State: " + employeeDet1.getAddress().getState());
										System.out.println(
												"Employee Pincode: " + employeeDet1.getAddress().getPinCode());
										System.out.println(
												"Employee Street: " + employeeDet1.getAddress().getStreet());
										System.out.println(); // Add an empty line for better readability
									}
								} else {
									System.out.println("No employees found.");
								}

								break;
							} else {
								throw new UnauthorizedException("Access denied for this admin");
							}
						} catch (UnauthorizedException e) {
							System.out.println(e.getMessage());
							break;
						}
					case 6:
						System.out.println("Do u want to login in again");
						char choice = sc.next().charAt(0);
						if (choice == 'y') {
							flag = true;
							EmsExecuter.main(new String[0]);
							break;
						} else {
							System.exit(0);
						}

					}

				}

			} catch (UnauthorizedException exception) {
				System.out.println(exception.getMessage());
				System.out.println("Try again");

				EmsExecuter.main(new String[0]);

			}
		} while (flag);
		sc.close();

	}

	static AdminDetails adminVerification(String adminName, String adminPassword) {
		for (AdminDetails list : AdminDetails.adminDetails) {
			if (list.getAdminName().equals(adminName) && list.getAdminPassword().equals(adminPassword)) {
				return list;
			}
		}
		return null;
	}

}
