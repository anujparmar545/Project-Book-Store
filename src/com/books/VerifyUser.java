package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String utype=request.getParameter("utype");
		
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		
		try{
			if(utype.equals("owner")){
				if(username.equals("admin") && password.equals("admin")){
					response.sendRedirect("adminpage.jsp");
				}else{
					out.println("INVALID CREDENTIALS FOR ADMIN");
				}
				
			}else{
				
				Connection con=Connect.getConn();
				String sql="SELECT username FROM USERS where username=? AND password=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,username);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					
					//whether user want to save the password
					String choice=request.getParameter("save");
					if(choice!=null){
						
						Cookie c1=new Cookie("id",username);
						Cookie c2=new Cookie("pw", password);
						
						c1.setMaxAge(60*60*24*7);
						c2.setMaxAge(60*60*24*7);
						
						response.addCookie(c1);
						response.addCookie(c2);
						
						
					}
					
					
					
					//response.sendRedirect("buyerpage.jsp");
					RequestDispatcher rd=request.getRequestDispatcher("buyerpage.jsp");
					rd.forward(request, response);
					
				}else{
					out.println("INVALID BUYER CREDENTIALS");
				}
				
			}
		}catch(Exception e){
			out.println(e);
		}
		
	}


}
