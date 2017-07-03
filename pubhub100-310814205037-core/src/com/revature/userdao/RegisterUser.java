package com.revature.userdao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.revature.connection.ConnectionUtil;
import com.revature.model.User;

public class RegisterUser implements com.revature.dao.RegisterUser{

	@Override
	public void register(User user)  {
		// TODO Auto-generated method stub
		
			Connection con=(Connection) ConnectionUtil.getConnection();
			String sql="insert into users1(name,email,password) values(?,?,?)";
		    PreparedStatement pst;
			try {
				pst = (PreparedStatement) con.prepareStatement(sql);
				pst.setString(1, user.getName());
			    pst.setString(2, user.getEmail());
			    pst.setString(3, user.getPassword());
			    int rows= pst.executeUpdate();
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			System.out.println("1 row created");	
		}

	}

	
	
	

