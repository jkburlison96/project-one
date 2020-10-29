package com.web.service;

import org.junit.Before;
import org.junit.Test;

import com.web.model.User;

public class UserServiceTest {
	private UserService us;
	
	@Before
	public void init() {
		us = new UserService();
	}
	
	@Test
	public void findByUsernamePassword() {
		User user = us.findByUsernamePassword("FinanceRules", "password");
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
	}
}
