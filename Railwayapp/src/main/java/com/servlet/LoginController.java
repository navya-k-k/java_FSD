package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.railway.UserDAO;
@WebServlet("/userlogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
        super();
    }
    private UserDAO loginDao;

    public void init()
    {
        loginDao = new UserDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        if (loginDao.validate(email, password)) {
	        	
	            RequestDispatcher dispatcher = request.getRequestDispatcher("user-dashboard.jsp");
	            dispatcher.forward(request, response);
	        } else {
	        	response.sendRedirect("user-login.jsp");
	    }
	
	}
}
