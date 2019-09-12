package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookAdd
 */
@WebServlet("/BookAdd")
public class BookAdd extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname=request.getParameter("txtBookName");
		String subject=request.getParameter("txtSubject");
		String author=request.getParameter("txtAuthor");
		String price=request.getParameter("txtPrice");
		
		response.setContentType("text/html");
		System.out.println(bookname+" "+subject+" "+author+" "+price);
		
		try {
			Connection con=Connect.getConn();
		String sql="insert into books(name,subject,author,price) values(?,?,?,?)";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, bookname);
	pst.setString(2,subject);
	pst.setString(3,author);
	pst.setString(4,price);
	
	int n=pst.executeUpdate();
	
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		PrintWriter out=response.getWriter();
		out.println("Book Added");
		
		out.println("<br><a href=\"adminpage.jsp\">Dashboard</a>");
	
	}

}
