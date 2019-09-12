package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookDetailsServlet
 */
@WebServlet("/BookDetailsServlet")
public class BookDetailsServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hitCount=1;
		HttpSession session=request.getSession();
		Map<String,Integer> map=(Map)session.getAttribute("map");
		
		String currentuser=request.getParameter("currentuser");
		//System.out.println(currentuser);
		
		if(!map.containsKey(currentuser))
			map.put(currentuser, 1);
		else
		{
			 hitCount= map.get(currentuser);
			hitCount+=1;
			map.replace(currentuser, hitCount);
			
		}
		
	//	System.out.println("COUNT"+map.get(currentuser));
		
		
		
		
		int bookid=Integer.parseInt(request.getParameter("code"));
		
		try{
			Connection con=Connect.getConn();
			String sql="select * from books where bookid="+bookid;
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			int fakeprice=0;
			int fakeprice2;
			PrintWriter out=response.getWriter();
			
			
			out.println("<table BORDER=1 CELLPADDING=10 CELLSPACING=0 WIDTH=100% >"
					+ "<tr><th>BOOK ID</th><th>BOOK NAME</th><th>SUBJECT</th><th>AUTHOR</th><th>PRICE</th></tr>");
			
			
			
		while(rs.next())
		{
			if(map.get(currentuser)>2 && map.get(currentuser)<=4 )
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
			if(map.get(currentuser)>4 )
			{
				fakeprice=Integer.parseInt(rs.getString(5));
				fakeprice2=(int)(fakeprice+fakeprice*0.2);
			out.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
					+ "<td><center>"+rs.getString(2)+"</center></td>"
							+ "<td><center>"+rs.getString(3)+"</center></td>"
							+ "<td><center>"+rs.getString(4)+"</center></td>"
							+ "<td><center>"+fakeprice2+"</center></td>"
							+ "</tr>");
			}
			if(map.get(currentuser)<=2)
			{
				out.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
						+ "<td><center>"+rs.getString(2)+"</center></td>"
								+ "<td><center>"+rs.getString(3)+"</center></td>"
								+ "<td><center>"+rs.getString(4)+"</center></td>"
								+ "<td><center>"+rs.getString(5)+"</center></td>"
								+ "</tr>");
			}
		out.println("</table>");
		out.println("<br><br>");
		out.println("<a href=\"CartManager?bookid="+bookid+"&currentuser="+currentuser+"\">Add To Cart</a>");
		out.println("<br><a href=\"SubjectPageServlet\">Subject Page</a>");
		
		}
			}
			
			
			catch(Exception e){e.printStackTrace();}
			
			}
	
	}

	


