package com.web.model;

public class Reimbursement {
	private final int id;
	private final int amount;
	private final String submitted;
	private final String resolved;
	private final String description;
	private final String receipt;
	private final String author;
	private final String resovler;
	private final ReimbursementStatus status;
	private final ReimbursementType type;
	
	public Reimbursement(ReimbursementBuilder builder) {
		this.id = builder.id;
		this.amount = builder.amount;
		this.submitted = builder.submitted;
		this.resolved = builder.resolved;
		this.description = builder.description;
		this.receipt = builder.receipt;
		this.author = builder.author;
		this.resovler = builder.resovler;
		this.status = builder.status;
		this.type = builder.type;
	}
	
	public int getID() {
		return id;
	}
	
	public int getAmount() {
		return amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public String getDescription() {
		return description;
	}

	public String getReceipt() {
		return receipt;
	}

	public String getAuthor() {
		return author;
	}

	public String getResovler() {
		return resovler;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public static class ReimbursementBuilder{
		private final int id;
		private final int amount;
		private  String submitted; //optional
		private  String resolved; //optional
		private final String description;
		private  String receipt; //optional
		private  final String author;
		private  String resovler; //optional
		private final  ReimbursementStatus status;
		private final  ReimbursementType type;
		
		public ReimbursementBuilder(int id, int amount, String description, String author, ReimbursementStatus status, ReimbursementType type) {
			this.id = id;
			this.amount = amount;
			this.description = description;
			this.author = author;
			this.status = status;
			this.type =type;
		}
		
		public ReimbursementBuilder submitted(String submitted) {
			this.submitted = submitted;
			return this;
		}
		
		public ReimbursementBuilder resolved(String resolved) {
			this.resolved = resolved;
			return this;
		}
		
		public ReimbursementBuilder receipt(String receipt) {
			this.receipt = receipt;
			return this;
		}
		
		public ReimbursementBuilder resolver(String resolver) {
			this.resovler = resolver;
			return this;
		}
		
		public Reimbursement build() {
			Reimbursement reimb = new Reimbursement(this);
			return reimb;
		}
	}
}
