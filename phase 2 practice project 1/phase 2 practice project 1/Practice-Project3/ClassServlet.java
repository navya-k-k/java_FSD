package com;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class ClassServlet extends GenericServlet implements Servlet
{
	private static final long serialVersionUID = 1L;
 
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out=res.getWriter();
		out.println("GENERIC SERVLET EXAMPLE");
	}

}
