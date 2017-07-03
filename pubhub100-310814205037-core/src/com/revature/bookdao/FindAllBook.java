package com.revature.bookdao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.revature.connection.ConnectionUtil;
import com.revature.model.Book;

public class FindAllBook {
	public List<Book> findall() 
	{

		Connection con=(Connection) ConnectionUtil.getConnection();
		String sql="select id,name,price,author from books";
		PreparedStatement pst=null;
		List<Book> books=new ArrayList<>();
		try {
			pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=(ResultSet) pst.executeQuery();
			
			while(rs.next())
			{
				Book book=new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setAuthor(rs.getString(4));
				books.add(book);
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
