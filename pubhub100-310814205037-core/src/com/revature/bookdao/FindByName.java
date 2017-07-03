package com.revature.bookdao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.revature.connection.ConnectionUtil;
import com.revature.model.Book;

public class FindByName {

	public List<Book> findbyname(Book book) 
	{
		Connection con=(Connection) ConnectionUtil.getConnection();
		String sql="select id,name,price,author from books where name=?";
		PreparedStatement pst=null;
		List<Book> books=new ArrayList<>();
		try {
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, book.getName());
			ResultSet rs=(ResultSet) pst.executeQuery();
			
			while(rs.next())
			{
				Book b=new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrice(rs.getInt(3));
				b.setAuthor(rs.getString(4));
				books.add(b);
			}
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

		
		return books;
		
	}
}
