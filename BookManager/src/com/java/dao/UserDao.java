package com.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.java.model.User;

import java.sql.PreparedStatement;

/**
 * �û�Dao��
 * @author Administrator
 * 
 */

public class UserDao {
	
	public User login(Connection con,User user)throws Exception {
		
		
		/**
		 * ��¼��֤
		 * @pram con
		 * @pram user
		 * 
		 */
		User resultUser =null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
	}
	
}
