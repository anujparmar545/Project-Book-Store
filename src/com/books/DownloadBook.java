package com.books;


import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownloadBook")
public class DownloadBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contenttype="";
		String book=request.getParameter("book");
		FileInputStream fis= new FileInputStream("D:/EclipseWorkspace/Worldpay/BookStore/files/"+book);
		if(book.endsWith("pdf"))
			contenttype="application/pdf";
		if(book.endsWith("doc"))
			contenttype="application/msword";
		if(book.endsWith("java"))
			contenttype="text/plain";
		
		response.setContentType(contenttype);
		byte[] b=new byte[fis.available()];
		fis.read(b);
		fis.close();
		ServletOutputStream sout=response.getOutputStream();
		sout.write(b);
		sout.close();
	
	}

	

}
