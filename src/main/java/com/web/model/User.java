package com.web.model;

public class User {
	private final String userName;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final UserRole userRole;
	
	public User(UserBuilder builder) {
		this.userName = builder.userName;
		this.password = builder.password;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.userRole = builder.userRole;
	}

	public String getUsername() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public UserRole getUserRole() {
		return userRole;
	}
	
	public static class UserBuilder{
		private final String userName;
		private final String password;
		private String firstName; //optional
		private String lastName; //optional
		private final String email;
		private final UserRole userRole;
		
		public UserBuilder(String userName, String password, String email, UserRole userRole) {
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.userRole = userRole;
		}
		
		public UserBuilder firstname(String firstname) {
			this.firstName = firstname;
			return this;
		}
		
		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public User build() {
			User user = new User(this);
			return user;
		}
	}
}
