package com.web.model;

public class ReimbursementType {
	private final String type;

	public ReimbursementType(String type) {
		this.type = type.toLowerCase();
	}
	
	public String getType() {
		return type;
	}
}
