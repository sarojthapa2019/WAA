 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
    </head>
    <body>
  
       <form method='get' action='MVC1Hello.jsp'>
			First Name: <input type = "text" size = 10 name = "firstName"/><br/>
			Last  Name: <input type = "text"  size = 10 name = "lastName"/><br/>
            <input type='submit' name='btnSubmit' value='MVC1'/>
        <br><br>
       </form>
        
   
        <form method='get' action='JSPMVC2'>
			First Name: <input type = "text" size = 10 name = "firstName"/><br/>
			Last  Name: <input type = "text"  size = 10 name = "lastName"/><br/>
           <input type='submit' name='btnSubmit' value='MVC2'/>
        <br><br>
        </form>
   
         <form method='get' action='JSPRedirect'>
					Your Name: <input type = "text" name = "yourName"/><br/>
            <input type='submit' name='btnSubmit' value='Redirect'/>
        <br>
        </form>
     </body>

</html>