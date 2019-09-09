package com.books;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect implements DBProps{           //Singleton Class

	private static Connection con;       
	
	
	 public static Connection getConn() 
	 {
			
		 
		 try {
			Class.forName(DRIVER);
			
			if(con==null)
			{
				con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				return con;
			}
		 }
		 catch (Exception e) {
			
			 e.printStackTrace();
		}
			
			return con;
		}

}
