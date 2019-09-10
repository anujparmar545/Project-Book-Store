package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/BookSearch")
public class BookSearch extends HttpServlet {
	
	private int hitCount;
	public void init()
	{
		hitCount=0;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		hitCount++;
		String bookname=request.getParameter("txtBookName");
		String subject=request.getParameter("txtSubject");
		String author=request.getParameter("txtAuthor");
		
		
		String sql = "SELECT * from books";
        String subsql = "";
        if (bookname.trim()!="")
            subsql = subsql + " name like '%" + bookname.trim()+ "%' and ";
        if (subject.trim() !="")
            subsql = subsql + " subject like '%" + subject.trim() + "%' and ";
        if (author.trim()!= "")
            subsql = subsql + " author like '%" + author.trim() + "%' and ";
        if (subsql != "")
            subsql = " where " + subsql.substring(0, subsql.lastIndexOf(" and"));
        sql = sql + subsql;
	
	try{
	Connection con=Connect.getConn();
	PreparedStatement pst=con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	
	PrintWriter out=response.getWriter();
	out.println("<table BORDER=1 CELLPADDING=10 CELLSPACING=0 WIDTH=100% >"
			+ "<tr><th>BOOK ID</th><th>BOOK NAME</th><th>SUBJECT</th><th>AUTHOR</th><th>PRICE</th></tr>");
	
	out.println("hitcount "+hitCount+"<br/>");
	while(rs.next())
	{
		int fakeprice=0;
		double fakeprice2;
		
	
		if(hitCount>2&& hitCount<=4)
		{
			fakeprice=Integer.parseInt(rs.getString(5));
			fakeprice+=fakeprice*0.1;
		out.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
				+ "<td><center>"+rs.getString(2)+"</center></td>"
						+ "<td><center>"+rs.getString(3)+"</center></td>"
						+ "<td><center>"+rs.getString(4)+"</center></td>"
						+ "<td><center>"+fakeprice+"</center></td>"
						+ "</tr>");
		}
		else if(hitCount>4)
		{
			fakeprice=Integer.parseInt(rs.getString(5));
			fakeprice2=fakeprice+fakeprice*0.2;
		out.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
				+ "<td><center>"+rs.getString(2)+"</center></td>"
						+ "<td><center>"+rs.getString(3)+"</center></td>"
						+ "<td><center>"+rs.getString(4)+"</center></td>"
						+ "<td><center>"+fakeprice2+"</center></td>"
						+ "</tr>");
		}
		else
			out.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
					+ "<td><center>"+rs.getString(2)+"</center></td>"
							+ "<td><center>"+rs.getString(3)+"</center></td>"
							+ "<td><center>"+rs.getString(4)+"</center></td>"
							+ "<td><center>"+rs.getString(5)+"</center></td>"
							+ "</tr>");
	}
	out.println("</table>");
	}
	
	
	catch(Exception e){e.printStackTrace();}
	
	}
}
