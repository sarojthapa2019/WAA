package mum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CurlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 *  Just doGet - No Post - so keeps submitting to doGet
	 *  
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  	
				// Value set in curl.jsp -Test of character encoding 
				System.out.println("C:URL encoding of URL paramter: Text= " + request.getParameter("text"));
 
		request.getRequestDispatcher("/curl.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doGet(request, response);
	}

}
