package mum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 *  Just doGet - No Post - so keeps submitting to doGet
	 *  
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  			// Set HIDE/SHOW value....for next round...
			String hidden = request.getParameter("hiddenfield");

				if (hidden.equals("Show")) request.setAttribute("hidden", "Show");
					else request.setAttribute("hidden", "Hide");
	
			// "on" is the default "value" when checked 
			String onOff = request.getParameter("onoffswitch");	
 
				request.setAttribute("onOff", onOff);
	
		request.getRequestDispatcher("/PublicFacade.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doGet(request, response);
	}

}
