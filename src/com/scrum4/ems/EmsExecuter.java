package com.scrum4.ems;
import java.util.*;
import com.scrum4.ems.data.admin.*;
import com.scrum4.ems.employee.*;
import com.scrum4.ems.exceptions.UnauthorizedException;
import com.scrum4.ems.service.EmsService;
public class EmsExecuter {
	public static void main(String[] args)
	{
		String adminName;
		String adminPassword;
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		do {
			System.out.println("Enter your name:");
			adminName=sc.next();
			
			System.out.println("Enter your password:");
			adminPassword=sc.next();
			
			AdminDetails details=new AdminDetails();
			try {
			if(!adminVerification(adminName,adminPassword))
			{
				throw new UnauthorizedException("Unauthorized adminName and password");
			}
			EmsService service=new EmsService();
			EmployeeInfo empInfo=new EmployeeInfo();
			EmployeeAddressDetails empAddress=new EmployeeAddressDetails();
			boolean showChoice=true;
			while(showChoice)
			{
				System.out.println("1.Add Employee Details");
				System.out.println("2.Update Employee Details");
				System.out.println("3.View Employee Details");
				System.out.println("4.View All Employee Details");
				System.out.println("5.Sort Employee Details");
				System.out.println("Enter your Choice");
				int serviceChoice=sc.nextInt();
				switch(serviceChoice)
				{
				case 1:
					
					Employee employee=new Employee(empInfo,empAddress);
					service.addEmployee(employee);
					break;
				case 2:
					System.out.println("Enter the Employees ID to be updated");
					int employeeId=sc.nextInt();
					service.updateEmployee(employeeId);
					
					break;
				case 3:
				    System.out.println("Enter the Employees ID to be searched");
				    int searchEmployeeID = sc.nextInt();
				    Employee foundEmployee = service.viewEmployee(searchEmployeeID);

				    if (foundEmployee != null) {
				        System.out.println("Employee found!");
				        System.out.println("Employee ID: " + foundEmployee.getInfo().getId());
				        System.out.println("Employee Name: " + foundEmployee.getInfo().getName());
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
							System.out.println("Employee Current Company: " + employeeDet.getInfo().getCurrentCompany());
							System.out.println("Employee Previous Company: " + employeeDet.getInfo().getPrevCompany());
							System.out.println("Employee Address Details:");
							System.out.println("Door No: " + employeeDet.getAddress().getDoorNo());
							System.out.println("Street: " + employeeDet.getAddress().getStreet());
							System.out.println("City: " + employeeDet.getAddress().getCity());
							System.out.println("State: " + employeeDet.getAddress().getState());
							System.out.println("Country: " + employeeDet.getAddress().getCountry());
							System.out.println("Pin Code: " + employeeDet.getAddress().getPinCode());
							System.out.println(); // Add an empty line for better readability
						}
					} else {
						System.out.println("No employees found.");
					}
					break;
				
					
				case 5:
					service.sortEmployeesByName();
					LinkedList<Employee> employeeDetails1 = service.viewAllEmployees();
					
					// Check if the list is not empty
					if (!employeeDetails1.isEmpty()) {
						// Iterate over the list and display details of each employee
						for (Employee employeeDet1 : employeeDetails1) {
							System.out.println("Employee ID: " + employeeDet1.getInfo().getId());
							System.out.println("Employee Name: " + employeeDet1.getInfo().getName());
							System.out.println("Employee Salary: " + employeeDet1.getInfo().getSalary());
							System.out.println("Employee Age: " + employeeDet1.getInfo().getAge());
							System.out.println("Employee Current Company: " + employeeDet1.getInfo().getCurrentCompany());
							System.out.println("Employee Previous Company: " + employeeDet1.getInfo().getPrevCompany());
							System.out.println("Employee Address Details:");
							System.out.println("Door No: " + employeeDet1.getAddress().getDoorNo());
							System.out.println("Street: " + employeeDet1.getAddress().getStreet());
							System.out.println("City: " + employeeDet1.getAddress().getCity());
							System.out.println("State: " + employeeDet1.getAddress().getState());
							System.out.println("Country: " + employeeDet1.getAddress().getCountry());
							System.out.println("Pin Code: " + employeeDet1.getAddress().getPinCode());
							System.out.println(); // Add an empty line for better readability
						}
					} else {
						System.out.println("No employees found.");
					}

					break;
				}
				
				
				
			}
			System.out.println("Do u want to login in again");
			char choice=sc.next().charAt(0);
			if(choice=='y')
			{
				flag=true;
			}
				}
			catch(UnauthorizedException exception)
			{
				System.out.println(exception.getMessage());
			}
			}while(flag);
		
	}
	static boolean adminVerification(String adminName,String adminPassword)
	{
		for(AdminDetails list:AdminDetails.adminDetails)
		{
			if(list.getAdminName().equals(adminName) && list.getAdminPassword().equals(adminPassword))
			{
				return true;
			}
		}
		return false;
	}

}
