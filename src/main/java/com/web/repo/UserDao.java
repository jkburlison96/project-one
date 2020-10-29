package com.web.repo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.web.model.User;
import com.web.model.UserRole;
import com.web.util.ConnectionUtil;

public class UserDao implements DaoContract<User, Integer> {
	final static Logger logger = Logger.getLogger(UserDao.class);
	
	public User findByUsernamePassword(String username, String password) {
		User user = null;
		String sql = "select * from complete_user where user_password = checkPass(?, ?)"; // this will sanitize the input
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User.UserBuilder(rs.getString(1), rs.getString(2), rs.getString(3), 
						new UserRole(rs.getString(4)))
						.firstname(rs.getString(5))
						.lastName(rs.getString(6))
						.build();
			}
			logger.info("username and password has been validated");
			rs.close();
		} catch (SQLException e) {
			logger.error("username and password could not be validated");
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User t) {
		String sql = "update users (username, user_password, user_first_name, user_last_name, user_email, user_role_id) "
				+ "values (?, ?, ?, ?, ?, get_user_role(?))"; // this will sanitize the input
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, t.getUsername());
			ps.setString(1, t.getPassword());
			ps.setString(1, t.getFirstName());
			ps.setString(1, t.getLastName());
			ps.setString(1, t.getEmail());
			ps.setString(1, t.getUserRole().getUserRole());
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int create(User t) {
		String sql = "insert into users (username, user_password, user_first_name, user_last_name, user_email, user_role_id) "
				+ "values (?, ?, ?, ?, ?, get_user_role(?))"; // this will sanitize the input
		try (Connection conn = ConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, t.getUsername());
			ps.setString(1, t.getPassword());
			ps.setString(1, t.getFirstName());
			ps.setString(1, t.getLastName());
			ps.setString(1, t.getEmail());
			ps.setString(1, t.getUserRole().getUserRole());
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
