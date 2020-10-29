package com.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Reimbursement;
import com.web.service.ReimbursementService;

public class ReimbursementDataController {

	private ReimbursementService rs;

	public ReimbursementDataController() {
		this.rs = new ReimbursementService();
	}
	
	public void sendAllData(HttpServletResponse res) {
		res.setContentType("text/json");
		List<Reimbursement> reimbursements = rs.findAll();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reimbursements));
		} catch (IOException e) {
		}
	}
	
}
