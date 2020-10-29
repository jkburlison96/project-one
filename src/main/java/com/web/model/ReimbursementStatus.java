package com.web.model;

public class ReimbursementStatus {
	private final String status;

	public ReimbursementStatus(String status) {
		this.status = status.toLowerCase();
	}

	public String getStatus() {
		return status;
	}
}
