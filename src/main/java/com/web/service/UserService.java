package com.web.service;

import com.web.model.User;
import com.web.repo.UserDao;

public class UserService {
	private UserDao ud;
	
	public UserService() {
		ud = new UserDao();
	}
	
	public User findByUsernamePassword(String username, String password) {
		return ud.findByUsernamePassword(username, password);
	}
	
	public int getID(String username) {
		return ud.getID(username);
	}
	
	public int save(User u) {
		return ud.create(u);
	}
}
