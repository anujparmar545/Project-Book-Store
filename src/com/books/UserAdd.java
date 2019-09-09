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
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	
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
		
		System.out.println(firstname+" "+lastname+" "+email+" "+mobile+" "+username+" "+password+" "+houseno+" "+colony+" "+area+" "+city+" "+state+" "+pincode);
		
		try {
		Connection con=Connect.getConn();
		String sql="insert into users(firstname,lastname,email,mobile,username,password,houseno,colony,area,city,state,pincode)";
			sql+=" values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, firstname);
		pst.setString(2,lastname);
		pst.setString(3,email);
		pst.setString(4,mobile);
		pst.setString(5,username);
		pst.setString(6,password);
		pst.setString(7,houseno);
		pst.setString(8,colony);
		pst.setString(9,area);
		pst.setString(10,city);
		pst.setString(11,state);
		pst.setString(12,pincode);
		
		int n=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		PrintWriter out=response.getWriter();
		out.println("Registered");
	}

}
