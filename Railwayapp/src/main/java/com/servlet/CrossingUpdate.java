package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.railway.Crossing;
import com.railway.CrossingDAO;
@WebServlet("/update")
public class CrossingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CrossingUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    private CrossingDAO crossingDao1;
    public void init()
    {
    	crossingDao1 = new CrossingDAO();
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
        
        
        Crossing cross=new Crossing();
        
        cross.setRid(rid);
        cross.setRname(rname);
        cross.setRaddress(raddress);
        cross.setRlandmark(rlandmark);
        cross.setRschedule(rschedule);
        cross.setRperson(rperson);
        cross.setRstatus(rstatus);
             
        crossingDao1.update(cross);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard.jsp");
        dispatcher.forward(request, response);
	}

}
