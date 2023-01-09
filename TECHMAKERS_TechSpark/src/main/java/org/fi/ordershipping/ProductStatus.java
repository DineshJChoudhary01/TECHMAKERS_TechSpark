package org.fi.ordershipping;

import java.io.IOException;

import javax.persistence.Query;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@WebServlet("/ProductStatus")
public class ProductStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SessionFactory hibernateFactory;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		Configuration hibernateConfiguration=new Configuration();
		hibernateConfiguration.configure("DatabaseConne.xml");
		hibernateFactory=hibernateConfiguration.buildSessionFactory();
		ServletContext application=getServletContext();
		application.setAttribute("hibernateFactory", hibernateFactory);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tmp =request.getParameter("agentId");
		int agentId=Integer.parseInt(tmp);
		String address = request.getParameter("address");
	    String agentName = request.getParameter("agentName");
	    String detailsOfProduct = request.getParameter("detailsOfProduct");
	    
	    AgentOrderDetails agentorderdetails=new AgentOrderDetails(agentId,  agentName,address,detailsOfProduct);
		try(Session hibernateSession=hibernateFactory.openSession();){
			
			hibernateSession.beginTransaction();
			hibernateSession.save(agentorderdetails);
			hibernateSession.getTransaction().commit();
			response.getWriter().println("Product and order  Details Saved...");

	    
	    
	}
		
	}
}
