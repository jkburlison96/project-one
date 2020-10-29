package com.web.model;

public class UserRole {
	private final String userRole;
	
	public UserRole(String userRole) {
		this.userRole = userRole.toLowerCase();
	}

	public String getUserRole() {
		return userRole;
	}
}
