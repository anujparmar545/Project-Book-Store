<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Books</title>
</head>
<body>
<form action ="BookSearch" method="get" style="margin-left: 500px;margin-top:100px; font-size: 16px;" >
	<b>	
	<pre>
Book Name		<input type="text" name="txtBookName"  placeholder="Enter Book Name"/><br/>
Book Subject		<input type="text" name="txtSubject" placeholder="Enter Subject"/><br/>
Book Author		<input type="text" name="txtAuthor" placeholder="Enter Author"><br/>
                        
                      <button type="submit" name="btnSignup"  ForeColor="Fuchsia">Search</button>
                        					

                        
	</pre>
	</b>
</form>
</body>
</html>