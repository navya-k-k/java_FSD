package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Post() 
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		PrintWriter out = response.getWriter();
		out.println("POST REQUEST EXAMPLE...!!!");
		
		String name = request.getParameter("name");
		out.println("WELCOME "+name);
	}

}
