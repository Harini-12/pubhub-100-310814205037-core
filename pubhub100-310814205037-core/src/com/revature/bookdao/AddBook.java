package com.revature.bookdao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.revature.connection.ConnectionUtil;
import com.revature.model.Book;

public class AddBook implements com.revature.dao.AddBook {

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Connection con = (Connection) ConnectionUtil.getConnection();
		String sql = "insert into books(name,price,author) values(?,?,?)";
		PreparedStatement pst=null;
		try {
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setInt(2, book.getPrice());
			pst.setString(3, book.getAuthor());
			int rows = pst.executeUpdate();
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

		System.out.println("row created");
	}

}
