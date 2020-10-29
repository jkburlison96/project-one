package com.web.repo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.web.model.Reimbursement;
import com.web.model.ReimbursementStatus;
import com.web.model.ReimbursementType;
import com.web.util.ConnectionUtil;

public class ReimbursementDao implements DaoContract<Reimbursement, Integer> {
	final static Logger logger = Logger.getLogger(UserDao.class);
	
	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbs = new ArrayList<>();
		String sql = "select * from complete_reimbursement"; // this will sanitize the input
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbs.add(new Reimbursement.ReimbursementBuilder(rs.getInt(1), rs.getString(2), rs.getString(3), 
						new ReimbursementStatus(rs.getString(4)), new ReimbursementType(rs.getString(5)))
						.submitted(rs.getString(6))
						.resolved(rs.getString(7))
						.receipt(rs.getString(8))
						.build());
			}
			logger.info("Successfully returned all reimbursements");
			rs.close();
		} catch (SQLException e) {
			logger.error("Failed to returned all reimbursements");
			e.printStackTrace();
		}
		
		return reimbs;
	}

	@Override
	public Reimbursement findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Reimbursement t) {
//		FileInputStream	fi = null;
		String sql = "update reimbursement set reimb_amount = ?, reimb_description = ?, reimb_author = ?, "
				+ "reimb_status_id = ?, reimb_type_id = get_reimb_type(?)"; // this will sanitize the input
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, t.getAmount());
			ps.setString(2, t.getDescription());
//			try {
//				fi = new FileInputStream("resources/blood.jpg");
//			} catch (FileNotFoundException e) {
//				// TODO: handle exception
//			}
//			ps.setBlob(3, fi);
			ps.setInt(3, 4);
			ps.setString(4, t.getStatus().getStatus());
			ps.setString(5, t.getType().getType());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int create(Reimbursement t) {
//		FileInputStream	fi = null;
		String sql = "insert into reimbursement (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) "
				+ "values (?, ?, ?, get_reimb_status(?), get_reimb_type(?))"; // this will sanitize the input
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, t.getAmount());
			ps.setString(2, t.getDescription());
//			try {
//				fi = new FileInputStream("resources/blood.jpg");
//			} catch (FileNotFoundException e) {
//				// TODO: handle exception
//			}
//			ps.setBlob(3, fi);
			ps.setInt(3, 4);
			ps.setString(4, t.getStatus().getStatus());
			ps.setString(5, t.getType().getType());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
