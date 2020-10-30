package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.User;
import com.web.service.UserService;

public class UserController {
	private UserService us;
	
	public UserController() {
		us = new UserService();
	}
	
	public User findByUsernamePassword(String username, String password) {
		return us.findByUsernamePassword(username, password);
	}
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/json");
		ObjectMapper om = new ObjectMapper();
		JsonNode jsonNode = om.readTree(req.getInputStream());
		String username = jsonNode.get("username").asText();
		String password = jsonNode.get("password").asText();
		User user = findByUsernamePassword(username, password);
		if(user != null) {
			System.out.println("success");
			try {
				res.getWriter().println(new ObjectMapper().writeValueAsString(user));
			} catch (IOException e) {
			}
		}
		else {
		}
	}
}
