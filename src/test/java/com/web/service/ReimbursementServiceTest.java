package com.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Reimbursement;
import com.web.model.ReimbursementStatus;
import com.web.model.ReimbursementType;

public class ReimbursementServiceTest {
	private ReimbursementService rs;
	private List<Reimbursement> reimbs;

//	@Before
//	public void init() {
//		rs = new ReimbursementService();
//		reimbs = rs.findAll();
//	}
//
//	@Test
//	public void isAuthorOfFirstReimbursementCorrect() {
//		if (reimbs != null) {
//			if (!(reimbs.isEmpty())) {
//				Reimbursement r = reimbs.get(0);
//				System.out.println(r.getAuthor());
//				assertEquals("e", r.getAuthor());
//			}
//		}
//	}
//
//	@Test
//	public void doesCreateCheckIDAndDeleteWork() {
//		Reimbursement reimb = new Reimbursement.ReimbursementBuilder(0, 200, "something", "fsa",
//				new ReimbursementStatus("pending"), new ReimbursementType("travel")).build();
//		rs.save(reimb);
//		List<Reimbursement> testSize = rs.findAll();
//		assertEquals((reimbs.size() + 1), testSize.size());
//		int result = rs.delete(rs.getID(reimb));
//		assertEquals(1, result);
//	}
}
