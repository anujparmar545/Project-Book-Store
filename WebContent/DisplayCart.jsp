<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Map"%>
<%@page import="com.books.Connect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Display Cart</title>
</head>
<body>

<%

PrintWriter pw=response.getWriter();

String currentuser=(String)request.getSession().getAttribute("username");
//System.out.println(currentuser);
int totalAmt=0;

response.setContentType("text/html");
pw.println("<center><h4>Cart Details</h4></center>");


Map<String,ArrayList<Integer>> map=(Map<String,ArrayList<Integer>>)getServletContext().getAttribute("collect1");
//System.out.println(map);

pw.println("<table BORDER=1 CELLPADDING=10 CELLSPACING=0 WIDTH=100% >"
		+ "<tr><th>BOOK ID</th><th>BOOK NAME</th><th>SUBJECT</th><th>AUTHOR</th><th>PRICE</th><th>Delete</th></tr>");

if(map!=null)
{
for(Map.Entry m:map.entrySet())
{
	ArrayList<Integer> arr=(ArrayList<Integer>)m.getValue();
	String user=(String)m.getKey();
	
	if(user.equals(currentuser))
	{
		
		try{
			Connection con=Connect.getConn();
			
			for(Integer x:arr){
				String sql="select * from books where bookid="+x;
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			

			while(rs.next()){
			pw.println("<tr><td><center>"+rs.getInt(1)+"</center></td>"
					+ "<td><center>"+rs.getString(2)+"</center></td>"
							+ "<td><center>"+rs.getString(3)+"</center></td>"
							+ "<td><center>"+rs.getString(4)+"</center></td>"
							+ "<td><center>"+rs.getInt(5)+"</center></td>"
							+ "<td><center><a href=\"DeleteFromCart?bookid="+rs.getInt(1)+"&currentuser="+currentuser+"\">Delete</a></center></td>" 
							+ "</tr>");
			totalAmt+=rs.getInt(5);
			}
			}
		}
		catch(Exception e){e.printStackTrace();}
	
		out.println("<center><h4> Total Cart Value: "+totalAmt+"</h4></center>");
		out.println("<br><a href=\"buyerpage.jsp\">Dashboard</a>");
		
	}
}
}

pw.println("</table>");




%>

</body>
</html>