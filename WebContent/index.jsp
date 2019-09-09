<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>

<style>

#menu
{
background-color:#808080;
color:#ffff33;
}
#menu ul li
{
display:inline-block;
padding:30px;

}
#menu ul li:hover
{
background-color:#99FF33;
}

</style>
</head>
<body>
<div style="background-image:url('image.jpg'); min-height: 100%; min-width: 1024px; width: 100%; height: auto;
        position: fixed;top: 0; left: 0;">

    
    <div >
    
           <div id="menu">
    
            <ul >
                 <li style="text-align:center;width:200px;font-size:40px"><a href="AddUser.jsp" style="text-decoration:none">Register</a></li>
                 <li style="text-align:center;width:200px;font-size:40px"><a href="AddBook.jsp" style="text-decoration:none">Add Books</a></li>
                <li style="text-align:center;width:300px;font-size:40px"><a href="SearchBook.jsp" style="text-decoration:none">Search Books</a></li>
                <li style="text-align:center;width:300px;font-size:40px"><a href="Download.jsp" style="text-decoration:none">Download Books</a></li>
                
            </ul>
            
        </div> 

    </div>



</div>
</body>
</html>