<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.books.Connect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Update Profile</title>
</head>
<body>


			<form action ="UserUpdate" method="post" style="margin-left: 200px;font-size: 16px;" >
				<b>	
				
<%
	String currentuser=(String)session.getAttribute("username");
	Connection con=Connect.getConn();
	String sql="SELECT * FROM users where username=?";
	//System.out.println(sql);
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, currentuser);
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{

%>
				<pre>	
                        			Signup
                        							
                        							
                        							
                        First Name			<input type="text" name="txtFirstName"  value="<%=rs.getString(2)%>">
                        
                        Last Name			<input type="text" name="txtLastName" value="<%=rs.getString(3) %>" >
                        
                        Email				<input type="text" name="txtEmail" value="<%=rs.getString(4) %>">
                        
                      	Mobile				<input type="text" name="txtMobile"  value="<%=rs.getString(5) %>" >    
                     
                      
                        Username			<input type="text" name="txtUser" readonly value="<%=rs.getString(6) %>" >
                        
                        Password			<input type="password" name="txtPass" value="<%=rs.getString(7) %>" >
                        
                        House No.			<input type="text" name="txtHouseNo"  value="<%=rs.getInt(8) %>" >
                        
                        Colony				<input type="text" name="txtColony" value="<%=rs.getString(9) %>" >
                        
                        Area				<input type="text" name="txtArea"  value="<%=rs.getString(10) %>" >
                        
                        City				<select name="city" ID="ddlCity" >
                        	 <option value="<%=rs.getString(11) %>"> <%=rs.getString(11) %> </option>
  							 <option value="Indore">Indore</option>
 							 <option value="Bhopal">Bhopal</option>
 							 <option value="Raisen">Raisen</option>
  							 <option value="Delhi">Delhi</option>
  							  <option value="Mumbai">Mumbai</option>
 							 <option value="Pune">Pune</option>
 							 <option value="Chennai">Chennai</option>
  							 <option value="Hyderabad">Hyderabad</option>
						</select>
                        
                        State				<input type="text" name="txtState" value="<%=rs.getString(12) %>" >
                        
                      Pincode				<input type="text" name="txtPincode"  value="<%=rs.getInt(13) %>">     
                        
                        
                        					<button type="submit" name="btnSignup"  ForeColor="Fuchsia">Register</button>
                        					
         <a href="buyerpage.jsp">DashBoard</a>
                        
                        
                       
                <%} %>      
                       
					</pre>	
					
				</b>



				</form>
	


</body>
</html>