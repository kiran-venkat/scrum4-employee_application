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
					service.addEmployee(employee,empInfo);
					break;
				case 2:
					
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
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
