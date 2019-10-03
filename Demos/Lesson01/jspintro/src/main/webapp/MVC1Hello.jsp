 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>MVC 1 - Hello page</title>
    </head>
    <body>
    <!-- "Controller" code built into JSP!!! with Scriptlets	 -->
    <%  
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
 		String myName = firstName + " " + lastName; 

    %>      
    Hello  <%= myName  %> <br>
    
         <p>
         <a href='index.jsp'>Go to Start</a>
        </p>
    </body>
</html>