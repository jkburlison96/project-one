package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.ReimbursementDataController;
import com.web.controller.SaveController;
import com.web.controller.UserController;

public class RequestForwarder {
	
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "./home.page":
			return "html/home.html";
		case "./reimbursementView.page":
			return "html/reimbursementView.html";
		case "./requestReimbursement.page":
			return "html/requestReimbursement.html";
		default: 
			return "html/login.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/p1/allReimbursements.json":
			new ReimbursementDataController().sendAllData(res);
			break;
		case "/p1/reqReimbursement.json":
			new SaveController().saveReimbursement(req, res);
			break;
		case "/p1/userLogin.json":
			new UserController().login(req, res);
			break;
		}
	}
}
