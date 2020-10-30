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
		case "/p1-0.0.1-SNAPSHOT/login.page":
			return "html/login.html";
		default: 
			return "html/wop.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/p1-0.0.1-SNAPSHOT/allReimbursements.json":
			new ReimbursementDataController().sendAllData(res);
			break;
		case "/p1-0.0.1-SNAPSHOT/reqReimbursement.json":
			new SaveController().saveReimbursement(req, res);
			break;
		case "/p1-0.0.1-SNAPSHOT/updateStatusReimbursements.json":
			new SaveController().updateStatus(req, res);
			break;
		case "/p1-0.0.1-SNAPSHOT/userLogin.json":
			new UserController().login(req, res);
			break;
		}
	}
}
