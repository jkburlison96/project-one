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
		case "/p1-0.0.1-SNAPSHOT/home.page":
			return "html/home.html";
		case "/p1-0.0.1-SNAPSHOT/reimbursementView.page":
			return "html/reimbursementView.html";
		case "/p1-0.0.1-SNAPSHOT/requestReimbursement.page":
			return "html/requestReimbursement.html";
		default: 
			return "html/login.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/p1-0.0.1-SNAPSHOT/js/allReimbursements.json":
			new ReimbursementDataController().sendAllData(res);
			break;
		case "/p1-0.0.1-SNAPSHOT/js/reqReimbursement.json":
			new SaveController().saveReimbursement(req, res);
			break;
		case "/p1-0.0.1-SNAPSHOT/js/userLogin.json":
			new UserController().login(req, res);
			break;
		}
	}
}
