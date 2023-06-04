package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.railway.Favorite;
import com.railway.FavoriteDAO;
@WebServlet("/favorite")
public class CrossingFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CrossingFavorite() {
        super();
        // TODO Auto-generated constructor stub
    }
    private FavoriteDAO favoriteDao;
    public void init()
    {
    	favoriteDao = new FavoriteDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer rid=Integer.parseInt(request.getParameter("rid"));
	 	String rname = request.getParameter("rname");
     	String raddress = request.getParameter("raddress");
        String rlandmark = request.getParameter("rlandmark");
        String rschedule = request.getParameter("rschedule");
        String rperson = request.getParameter("rperson");
       String rstatus = request.getParameter("rstatus");

        PrintWriter out=response.getWriter();
        out.println("hy");
        Favorite fav=new Favorite();
        
        fav.setRid(rid);
        fav.setRname(rname);
        fav.setRaddress(raddress);
        fav.setRlandmark(rlandmark);
        fav.setRschedule(rschedule);
        fav.setRperson(rperson);
        fav.setRstatus(rstatus);


        favoriteDao.store(fav);
       
        response.setContentType("text/plain");
        response.getWriter().write("Favorite item saved successfully");
	}

}
