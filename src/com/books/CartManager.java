package com.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartManager1
 */
@WebServlet("/CartManager")
public class CartManager extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String currentuser=request.getParameter("currentuser");
		
		//System.out.println("user="+currentuser);
		
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		
		ServletContext context=getServletContext();
		Map<String, ArrayList<Integer>> map=(Map<String, ArrayList<Integer>>)context.getAttribute("collect1");
		ArrayList<Integer> booklist=new ArrayList<>();
		if(map==null)
		{
			map=new HashMap<>();
			booklist.add(bookid);
			map.put(currentuser, booklist);
			context.setAttribute("collect1", map);
		
		}
		else
		{
			if(map.containsKey(currentuser))
			{
				booklist=map.get(currentuser);
				booklist.add(bookid);
				map.replace(currentuser, booklist);
				context.setAttribute("collect1", map);
			}
			else
			{
				booklist.add(bookid);
				map.put(currentuser, booklist);
				context.setAttribute("collect1", map);
			}
		}
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("DisplayCart.jsp");
		rd.forward(request, response);
	}
		
	}
	
	

	
	


