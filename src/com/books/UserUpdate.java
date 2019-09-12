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
 * Servlet implementation class UpdateData
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String firstname=request.getParameter("txtFirstName");
		String lastname=request.getParameter("txtLastName");
		String email=request.getParameter("txtEmail");
		String mobile=request.getParameter("txtMobile");
		String username=request.getParameter("txtUser");
		String password=request.getParameter("txtPass");
		String houseno=request.getParameter("txtHouseNo");
		String colony=request.getParameter("txtColony");
		String area=request.getParameter("txtArea");
		String city=request.getParameter("city");
		String state=request.getParameter("txtState");
		String pincode=request.getParameter("txtPincode");
		int n=0;
		try {
			
			Connection con=Connect.getConn();
			String sql="update users set firstname=?, lastname=?, email=?, mobile =?, password=?, houseno=?, colony=?, area =?, city=?, state=?, pincode=? where username=?";
				
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, firstname);
			pst.setString(2,lastname);
			pst.setString(3,email);
			pst.setString(4,mobile);
			pst.setString(5,password);
			pst.setString(6,houseno);
			pst.setString(7,colony);
			pst.setString(8,area);
			pst.setString(9,city);
			pst.setString(10,state);
			pst.setString(11,pincode);
			pst.setString(12,username);
			System.out.println(sql);
			n=pst.executeUpdate();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(n!=0)
			out.println("User updated<br><br>");
		out.println("<a href=\"buyerpage.jsp\">Buyer-Page</a>");
	}

	

}
