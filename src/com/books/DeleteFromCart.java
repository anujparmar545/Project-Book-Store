package com.books;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteFromCart
 */
@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		HttpSession session=request.getSession();
		String currentuser=request.getParameter("currentuser");
		Map<String,ArrayList<Integer>> map=(Map<String,ArrayList<Integer>>)getServletContext().getAttribute("collect1");
		
		if(map!=null)
		{
		for(Map.Entry m:map.entrySet())
		{
			String user=(String)m.getKey();
			if(user.equals(currentuser))
			{
			ArrayList<Integer> arr=(ArrayList<Integer>)m.getValue();
			System.out.println(arr);
			System.out.println(arr.remove(Integer.valueOf(bookid)));
			
			session.setAttribute("collect1",map);
			}
		}
		}
		response.sendRedirect("DisplayCart.jsp");
		//RequestDispatcher rd=request.getRequestDispatcher();
		//rd.forward(request, response);
		
		
	}


}
