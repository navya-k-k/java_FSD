package com.ecommerce;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/init")
public class DBConnect extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out = response.getWriter();

		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			 if(DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Meghamysql@123") != null)
			 {

	              out.println("DATABASE CONNECTION ESTABLISHED!!");
			 }
		} 
		catch (ClassNotFoundException | SQLException e) 
		{

              out.println("DATABASE CONNECTION NOT ESTABLISHED!!");
		}
		
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

	
}
