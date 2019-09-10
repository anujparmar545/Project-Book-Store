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
		<a href="SearchBook.jsp">Search-Book</a>
		<a href="">View-Cart</a>
		<a href="">Trace-Order</a>
		<a href="">Logout</a>
	</pre>		
	<hr>

</body>
</html>