package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookListServlet1
 */
@WebServlet("/BookDetailsServlet1")
public class BookDetailsServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String currentuser=(String)session.getAttribute("username");
		String[] subjects=request.getParameterValues("subject");
		StringJoiner sj=new StringJoiner(",");
		
		for(String s:subjects)
		{
			sj.add("'"+s+"'");
		}
		
		System.out.println(sj);
		
		
		try{
			Connection con=Connect.getConn();
			String sql="select * from books where subject in ("+sj+")";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			PrintWriter out=response.getWriter();
			
			
			out.println("<table BORDER=1 CELLPADDING=10 CELLSPACING=0 WIDTH=100% >"
					+ "<tr><th>BOOK ID</th><th>BOOK NAME</th><th>SUBJECT</th><th>AUTHOR</th><th>PRICE</th><th>Add To Cart</th></tr>");
			
			
			
		while(rs.next())
		{
			
			out.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
					+ "<td><center>"+rs.getString(2)+"</center></td>"
							+ "<td><center>"+rs.getString(3)+"</center></td>"
							+ "<td><center>"+rs.getString(4)+"</center></td>"
							+ "<td><center>"+rs.getString(5)+"</center></td>"
							+ "<td><center><a href=\"CartManager?bookid="+rs.getInt(1)+"&currentuser="+currentuser+"\">Add To Cart</a></center></td>"
							+ "</tr>");
			
		}	
		out.println("</table>");
		out.println("<br><br>");
		out.println("<br><a href=\"SubjectPageServlet\">Subject Page</a>");
		
		
			}
			
			
			catch(Exception e){e.printStackTrace();}
			
		
		
	}

	

}
