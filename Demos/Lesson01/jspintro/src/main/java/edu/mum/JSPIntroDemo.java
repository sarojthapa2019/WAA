/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class JSPIntroDemo extends HttpServlet {

     /** 
      * MVC 2 Example
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
 		String myName = firstName + " " + lastName; 
    	
    	request.setAttribute("myName", myName);
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("MVC2Hello.jsp");
        dispatcher.forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
     	String dayString = request.getParameter("dayOfWeek");
    	int	day = Integer.parseInt(dayString);
    	
     	
    	String dayName;
      	switch(day) {
      	case 1:
      	   dayName = "Sunday";
      	   break;
      	case 2:
      		dayName = "Monday";
      	   break;
      	case 3:
      		dayName = "Tuesday";
      	   break;
      	case 4:
      		dayName = "Wednesday";
      	   break;
      	case 5:
      		dayName = "Thursday";
      	   break;
      	case 6:
      		dayName = "Friday";
      	   break;
      	default:
      		dayName = "Saturday";
      	}
      		
      	request.setAttribute("dayName", dayName);
      	request.setAttribute("dayNumber", day );
      	
        RequestDispatcher dispatcher = request.getRequestDispatcher("PostMessage.jsp");
       	dispatcher.forward(request, response);
    }


}
