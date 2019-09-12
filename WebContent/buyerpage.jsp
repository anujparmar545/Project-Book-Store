<html>
<head>
<title>Buyer page</title>
</head>
<body>
<%String s=(String)session.getAttribute("username"); %>
<h3>DashBoard-For-<%=s %></h3>
	<hr>
	<pre>
		<a href="SubjectPageServlet">Explore-Store</a>
		<a href="SubjectPageServlet1">Explore-Store1</a>
		<a href="SearchBook.jsp">Search-Book</a>
		<a href="DisplayCart.jsp">View-Cart</a>
		<a href="">Trace-Order</a>
		<a href="UpdateProfile.jsp">Update Profile</a>
		<a href="Logout">Logout</a>
	</pre>		
	<hr>

</body>
</html>