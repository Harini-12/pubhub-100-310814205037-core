package com.revature.userdao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.revature.connection.ConnectionUtil;
import com.revature.model.User;

public class LoginUser implements com.revature.dao.LoginUser {

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		
		Connection con=(Connection) ConnectionUtil.getConnection();
		String sql="select name from users1 where email=? and password=?";
	    PreparedStatement pst;
	    boolean flag=false;
		try {
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, "xyz@gmsil.com");
		    pst.setString(2, "passwrd");
		   
		    ResultSet rs=(ResultSet) pst.executeQuery();
		    if(rs.next())
		    {
		    	flag=true;
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		return flag;
	}

}
