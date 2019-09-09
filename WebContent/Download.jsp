<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="margin-left:200px">
<%
File directory= new File("D:/EclipseWorkspace/Worldpay/BookStore/files");
int count=directory.list().length;
System.out.println("total files "+count);
String[] arr=directory.list();
PrintWriter pw= response.getWriter();

for(String s:arr)
{
	System.out.println(s);
	if(s.endsWith("pdf"))
	{
	pw.println("<a href=DownloadBook?book="+s+">"+s+"<br/>");
	
	}
	if(s.endsWith("doc"))
		pw.println("<a href='DownloadBook?book="+s+"'>"+s+"<br/>");
	
	if(s.endsWith("java"))
		pw.println("<a href=DownloadBook?book="+s+">"+s+"<br/>");
	

}

%>
</div>
</body>
</html>