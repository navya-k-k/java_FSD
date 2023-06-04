package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.railway.UserDAO;
@WebServlet("/adminlogin")
public class LoginControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginControllerAdmin() {
        super();
    }
    private UserDAO loginDaoAdmin;

    public void init()
    {
    	loginDaoAdmin = new UserDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        if (loginDaoAdmin.validateAdmin(email, password)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard.jsp");
	            dispatcher.forward(request, response);
	        } else {
	        	
	        	response.sendRedirect("admin-login.jsp?name=ADMIN");
	    }
	}

}
