package com.web.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BuilderTest {
	@Test
	public void buildUser() {
		UserRole ur = new UserRole("emp");
		User user = new User.UserBuilder("Bob.emp", "pass", "bob@gmail.com", ur).build();
		assertTrue(user != null);
		assertTrue(user.getUsername().equals("Bob.emp"));
		assertTrue(user.getPassword().equals("pass"));
		assertTrue(user.getEmail().equals("bob@gmail.com"));
		assertTrue(user.getUserRole().getUserRole() == "emp");
		assertTrue(user.getFirstName() == null);
	}
	
	@Test
	public void buildReimbursment() {
		ReimbursementStatus rs = new ReimbursementStatus("Pending");
		ReimbursementType rt = new ReimbursementType("Travel");
		Reimbursement r = new Reimbursement.ReimbursementBuilder(100, "desc", "Bob.emp", rs, rt)
				.submitted("10-23-2020")
				.build();
		assertTrue(r.getAmount() == 100);
		assertTrue(r.getStatus().getStatus().equals("pending"));
		assertTrue(r.getType().getType().equals("travel"));
		assertTrue(r.getSubmitted().equals("10-23-2020"));
		assertTrue(r.getResolved() == null);
	}
}
