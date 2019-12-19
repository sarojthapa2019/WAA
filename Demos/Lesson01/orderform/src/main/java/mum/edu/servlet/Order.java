package mum.edu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
 
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Store servlet init-param here
	 String servletName;
	
	   @Override
	    public void init( ) throws ServletException {

	     servletName = getServletConfig().getInitParameter("servletName");
 	    }	
	    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// make init-param servletName available to JSP
		request.setAttribute("servletName",servletName);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/order.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		request.setAttribute("name", request.getParameter("name"));	
		request.setAttribute("address", request.getParameter("address"));
		request.setAttribute("country", request.getParameter("country"));
		request.setAttribute("deliveryMethod", request.getParameter("deliveryMethod"));
		
		String catalogRequest = request.getParameter("catalogRequest");
		if (catalogRequest == null)
			catalogRequest ="No";
		else catalogRequest = "Yes";
		request.setAttribute("catalogRequest", catalogRequest);
 		
		
        String[] instructions = request.getParameterValues("instruction");
        request.setAttribute("instructions", instructions);
        
 	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/orderDetails.jsp");
		requestDispatcher.forward(request, response);
		
	}
 

}
