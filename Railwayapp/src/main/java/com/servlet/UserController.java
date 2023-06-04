package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.railway.*;

@WebServlet("/register")
public class UserController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
     private UserDAO userDao;
    public UserController() 
    {
        super();
    }
    public void init() {
        userDao = new UserDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String uname = request.getParameter("uname");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        User user = new User();
	        
	        user.setUname(uname);
	        user.setEmail(email);
	        user.setPassword(password);
	        
	        userDao.register(user,response);
	       
	    }
	
	}


