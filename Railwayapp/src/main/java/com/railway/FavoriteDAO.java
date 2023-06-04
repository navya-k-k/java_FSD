package com.railway;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.servlet.HibernateUtil;

public class FavoriteDAO 
{
	public void store(Favorite fav) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(fav);
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
	
	

	
}
