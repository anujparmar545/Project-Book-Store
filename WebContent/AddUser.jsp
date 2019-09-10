<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add books</title>


     
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" 	   href="../images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/vendor/bootstrap/css/bootstrap.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/fonts/iconic/css/material-design-iconic-font.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/vendor/animate/animate.css"/>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="BookStore/vendor/css-hamburgers/hamburgers.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/vendor/animsition/css/animsition.min.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/vendor/select2/select2.min.css"/>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="BookStore/vendor/daterangepicker/daterangepicker.css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="BookStore/css/util.css"/>
	<link rel="stylesheet" type="text/css" href="BookStore/css/main.css"/>
<!--===============================================================================================-->


</head>
<body>

				<form action ="UserAdd" method="post" style="margin-left: 200px;font-size: 16px;" >
				<b>	
				<pre>	
                        			Signup
                        							
                        							
                        							
                        First Name			<input type="text" name="txtFirstName"  placeholder="Enter First Name"/>
                        
                        Last Name			<input type="text" name="txtLastName" placeholder="Enter Last Name"/>
                        
                        Email				<input type="text" name="txtEmail" placeholder="Enter Email">
                        
                        Mobile				<input type="text" name="txtMobile"  placeholder="Enter Contact Number" >
                        
                        Username			<input type="text" name="txtUser" placeholder="Enter Username" >
                        
                        Password			<input type="password" name="txtPass" placeholder="Enter Password" >
                        
                        Repeat Password			<input type="password" name="txtRepeatPass" placeholder="Confirm Password" >
                        
                        House No.			<input type="text" name="txtHouseNo"  placeholder="Enter House Number" >
                        
                        Colony				<input type="text" name="txtColony" placeholder="Enter Colony" >
                        
                        Area				<input type="text" name="txtArea"  placeholder="Enter Area" >
                        
                        City				<select name="city" ID="ddlCity" >
  							 <option value="Indore">Indore</option>
 							 <option value="Bhopal">Bhopal</option>
 							 <option value="Raisen">Raisen</option>
  							 <option value="Delhi">Delhi</option>
  							  <option value="Mumbai">Mumbai</option>
 							 <option value="Pune">Pune</option>
 							 <option value="Chennai">Chennai</option>
  							 <option value="Hyderabad">Hyderabad</option>
						</select>
                        
                        State				<input type="text" name="txtState" placeholder="Enter State" >
                        
                        Pincode				<input type="text" name="txtPincode"  placeholder="Enter pincode" >
                        
                        
                        					<button type="submit" name="btnSignup"  ForeColor="Fuchsia">Register</button>
                        					
                        					<a href="../Login/Login.aspx">Sign in</a>
                        
					</pre>	
					
				</b>



				</form>
			

</body>
</html>