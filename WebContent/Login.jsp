<%
	String s1="",s2="";

	//to read the cookies
	//step-1 (fetch all the cookies coming with request)
		Cookie ck[]=request.getCookies();
	//step-2 (search for the desired one)
	if(ck!=null)
		for(Cookie c:ck){
			String name=c.getName();
			if(name.equals("id")){
				s1=c.getValue();
			}else if(name.equals("pw")){
				s2=c.getValue();
			}
		}

%>



<html>
<head>
<title>Log In</title>
</head>
<body>
<h4>Online Book Store</h4>
	<hr><b>
	<form action="VerifyUser">
	<pre>
		Username		<input type="text" name="username" value="<%=s1%>"  /><br>
		Password		<input type="password" name="password" value="<%=s2%>"  /><br>
		RememberMe		<input type="checkbox" name="save" value="yes" checked="checked" /><br>
		Usertype	owner	<input type="radio" name="utype" value="owner" checked="checked"/>    buyer <input type="radio" name="utype" value="buyer"/>
					
					<input type="submit" value="Login"/>
	</pre>
	</form>
	<hr></b>
	<a href="registration.jsp">New-User</a>
</body>
</html>