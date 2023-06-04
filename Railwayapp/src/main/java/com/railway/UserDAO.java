package com.railway;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.servlet.HibernateUtil;

import jakarta.servlet.http.HttpServletResponse;

public class UserDAO 
{
	public void register(User user,HttpServletResponse response) throws IOException 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(user);
            // commit transaction
            transaction.commit();
            response.sendRedirect("user-dashboard.jsp");


        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                response.sendRedirect("fail-register.jsp");
                transaction.rollback();
            }
            e.printStackTrace();
        }
}
	
	
	 public boolean validate(String email, String password) {

	        Transaction transaction = null;
	        User user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email)
	                .uniqueResult();

	            if (user != null && user.getPassword().equals(password)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 public boolean validateAdmin(String email, String password) {

	        Transaction transaction = null;
	        User user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	           
	            if (email.equals("admin@gmail.com") && password.equals("admin")) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }
}
