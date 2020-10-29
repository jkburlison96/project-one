package com.web.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Reimbursement;

public class ReimbursementServiceTest {
	private ReimbursementService rs;
	private List<Reimbursement> reimbs;
	
	@Before
	public void init() {
		rs = new ReimbursementService();
		reimbs = rs.findAll();
	}
	
	@Test
	public void isAuthorOfFirstReimbursementCorrect() {
		if(reimbs != null) {
			if(!(reimbs.isEmpty())) {
				Reimbursement r = reimbs.get(0);
				System.out.println(r.getAuthor());
				assertEquals("e", r.getAuthor());
			}
		}
	}
}
