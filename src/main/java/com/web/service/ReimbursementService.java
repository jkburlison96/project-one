package com.web.service;

import java.util.List;
import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;

public class ReimbursementService {
	private ReimbursementDao rd;
	
	public ReimbursementService() {
		this.rd = new ReimbursementDao();
	}

	public List<Reimbursement> findAll(){
		return rd.findAll();
	}
	
	public int updateStatus(int id, String status) {
		return rd.updateStatus(id, status);
	}
	
	public int save(Reimbursement t) {
		return rd.create(t);
	}
	
	public int delete(int id) {
		return rd.delete(id);
	}
	
	public int getID(Reimbursement t) {
		return rd.getID(t);
	}
}
