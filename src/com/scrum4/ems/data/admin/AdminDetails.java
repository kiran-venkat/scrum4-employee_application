package com.scrum4.ems.data.admin;

import java.util.*;

public class AdminDetails {
	private int adminId;
	private String adminName;
	private String adminPassword;
	private String adminRole;
	public static ArrayList<AdminDetails> adminDetails = new ArrayList<>();
	static {
		AdminDetails admin_1 = new AdminDetails(001, "Nivetha", "nivi@23", "Admin_ALL");
		AdminDetails admin_2 = new AdminDetails(002, "Roshan", "roshan@23", "Admin_VIEW");
		AdminDetails admin_3 = new AdminDetails(003, "Kiran", "kiran@23", "Admin_VIEW");
		adminDetails.add(admin_1);
		adminDetails.add(admin_2);
		adminDetails.add(admin_3);
	}

	public static ArrayList<AdminDetails> getAdminDetails() {
		return adminDetails;
	}

	public AdminDetails() {

	}

	public AdminDetails(int adminId, String adminName, String adminPassword, String adminRole) {

		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminRole = adminRole;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

}
