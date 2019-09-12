package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubjectPageServlet1
 */
@WebServlet("/SubjectPageServlet1")
public class SubjectPageServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	


		String s1="";

		//to read the cookies
		//step-1 (fetch all the cookies coming with request)
			Cookie ck[]=request.getCookies();
		//step-2 (search for the desired one)
		if(ck!=null)
			for(Cookie c:ck){
				String name=c.getName();
				if(name.equals("subject"))
					s1=c.getValue();
				
			}
		

	
		
		
		PrintWriter out=response.getWriter();
		try{
		Connection con=Connect.getConn();
		String sql="SELECT distinct subject from books";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		out.println("<html>");
		out.println("<html><body>");
		out.println("<form action=\"BookDetailsServlet1\" method=\"get\">");
		if(s1!="")
			out.println("<marquee><h4>Attractive Offers On "+s1+"</h4></marquee>");
		else
			out.println("<marquee><h4>Attractive Offers On All Books</h4></marquee>");
		out.println("<h3>Select The Desired Subject</h3>");
		out.println("<hr>");
		while(rs.next()){
			String sub=rs.getString(1);
			out.println("<input type=\"checkbox\" multiple=\"multiple\" name=\"subject\" value='"+sub+"'>"+sub+"<br>");
			
		}
		
		out.println("<br><br><br><button type=\"submit\" name=\"btnSignup\" >Search</button>");
		
		out.println("<hr>");
		out.println("<a href=buyerpage.jsp>DashBoard</a>");
		out.println("</form>");
		out.println("</body></html>");
		
		
		
		
		}catch(Exception e){
			out.println(e);
		}
		
		
	}

	

}
