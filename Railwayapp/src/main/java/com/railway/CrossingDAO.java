package com.railway;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.servlet.HibernateUtil;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class CrossingDAO 
{
	public void add(Crossing cross,HttpServletResponse response) throws IOException 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(cross);
            // commit transaction
            transaction.commit();
            response.sendRedirect("admin-dashboard.jsp");


        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                response.sendRedirect("fail-add.jsp");

                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
	public void update(Crossing cross) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.saveOrUpdate(cross);
            // commit transaction
            transaction.commit();

        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
}
	
	
	public Crossing select(Crossing cross)
	{
		Transaction transaction = null;
		Crossing result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            String sql="FROM Crossing WHERE rid= :rid";
            Query query =session.createQuery(sql);
            query.setParameter("rid", cross.getRid());
            result=(Crossing) query.uniqueResult();
        
        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		
        return result;

		
	}
	
	public Crossing select1(Crossing cross)
	{
		Transaction transaction = null;
		Crossing result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            String sql="FROM Crossing WHERE rid= :rid";
            Query query =session.createQuery(sql);
            query.setParameter("rid", cross.getRid());
            result=(Crossing) query.uniqueResult();
        
        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		
        return result;

		
	}
	public List<Crossing> search(Crossing cross) {
	    List<Crossing> results = new ArrayList<>();

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String sql = "FROM Crossing WHERE raddress LIKE :raddress";
	        Query query = session.createQuery(sql);
	        query.setParameter("raddress", "%" + cross.getRaddress() + "%");
	        results = query.list();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return results;
	}
	public void delete(Crossing cross)
	{
		Transaction transaction = null;
		Crossing result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
           session.delete(cross);
            // commit transaction
            transaction.commit();
            session.close();

        } 
        catch (Exception e) 
        {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		

		
	}
	
}
