package com.revature.bookdao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.revature.connection.ConnectionUtil;
import com.revature.model.Book;

public class RemoveBook {

	public void removebook(Book book) {
		Connection con = ConnectionUtil.getConnection();
		String sql = "delete from books where name=?";
		PreparedStatement pst=null;
		try {
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, book.getName());
			int rows = pst.executeUpdate();
			System.out.println("row deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	}

}
