 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>MVC 2 - Hello page</title>
    </head>
    <body>
   <h3> Hello  ${myName} </h3>
  
   <!-- ----------------------------- -->
   
   
   <h5> Let's exercise some Scripting...</h5>
        <form method='post' action='JSPMVC2'>
Day of Week[1-7]: <input type = "text" name = "dayOfWeek"/><br/>
            <input type='submit' name='btnSubmit' value='Click me'/>
        </form>
    </body>
</html>