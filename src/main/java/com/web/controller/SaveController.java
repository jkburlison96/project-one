package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Reimbursement;
import com.web.model.ReimbursementStatus;
import com.web.model.ReimbursementType;
import com.web.model.User;
import com.web.service.ReimbursementService;
import com.web.service.UserService;

public class SaveController {
	private ReimbursementService rs;
	private UserService us;

	public SaveController() {
		rs = new ReimbursementService();
		us = new UserService();
	}

	public void updateStatus(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonNode = om.readTree(req.getInputStream());
			int id = jsonNode.get("id").asInt(0);
			String status = jsonNode.get("status").asText();
			if (id > 0 && status != null) {
				rs.updateStatus(id, status);
				res.getWriter().println("the user is added");
			}
		} catch (IOException e) {
			res.getWriter().println("something went wrong");
		}

	}

	public void saveReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
//			Reimbursement r = new ObjectMapper().readValue(req.getInputStream(), Reimbursement.class);
			ObjectMapper om = new ObjectMapper();
			JsonNode jsonNode = om.readTree(req.getInputStream());
			System.out.println(jsonNode.get("type").get("type").asText());
			Reimbursement r = new Reimbursement.ReimbursementBuilder(jsonNode.get("id").asInt(),
					jsonNode.get("amount").asInt(), jsonNode.get("description").asText(),
					jsonNode.get("author").asText(), new ReimbursementStatus("PENDING"),
					new ReimbursementType(jsonNode.get("type").get("type").asText())).build();
			rs.save(r);
			res.getWriter().println("the reimbursement was added");
		} catch (IOException e) {
			e.printStackTrace();
			res.getWriter().println("something went wrong");
		}
	}

	public void saveUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			User u = new ObjectMapper().readValue(req.getInputStream(), User.class);
			us.save(u);
			res.getWriter().println("the user is added");
		} catch (IOException e) {
			e.printStackTrace();
			res.getWriter().println("something went wrong");
		}
	}
}
