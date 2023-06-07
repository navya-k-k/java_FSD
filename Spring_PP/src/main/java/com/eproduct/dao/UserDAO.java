package com.eproduct.dao;

import java.sql.*;
import java.util.List;

import org.springframework.jdbc.core.*;

import com.eproduct.Users;

public class UserDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// Business methods
	public Users getProductById(int userId) {
	    String query = "SELECT * FROM users WHERE user_id = ?";
	    return template.queryForObject(query, new Object[]{userId}, new RowMapper<Users>() {
	        public Users mapRow(ResultSet rs, int row) throws SQLException {
	            Users e = new Users();
	            e.setUser_id(rs.getInt(1));
	            e.setUname(rs.getString(2));
	            e.setAge(rs.getInt(3));
	            
	         
	            return e;
	        }
	    });
	}
	public boolean updateUser(Users user) {
	    String query = "UPDATE users SET uname = ?, age = ?  WHERE user_id = ?";
	    template.update(query, user.getUname(), user.getAge(),user.getUser_id());
	    return true;
	}


}
