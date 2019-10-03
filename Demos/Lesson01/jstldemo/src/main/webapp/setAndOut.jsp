<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Core Tags Example</title>
</head>
<body>


<br>
    <!-- sets variable test so it has value "JSTL and/or EL" -->
    <c:set var="test" value="JSTL -and/or- EL WITHOUT 'ESCAPE' characters in String"></c:set>

    <!-- prints to the page the value of the variable 'test' -->
    
    <h3>JSTL EL & C:OUT - If NO Escape Characters in String - BOTH [EL & C:OUT] print Same results   </h3>
    <b>JSTL c:out Example -- </b><br>
    <c:out value="${test}"></c:out> 

    <br><br>

    <b>EL EXAMPLE-- </b><br>
    ${test}

    <br><br>
    
    <!-- Demo escape character function of C:OUT 
    	SAME as using fn:escapeXml with EL 
    	BOTH avoid XSS attack
    	HOWEVER "just" EL with cause javascript execution!!!!
    	-->
    <c:set var="test" value="JSTL ---<script>alert('Oh no! You have been hacked AGAIN!!')</script>---- EL"></c:set>
  
    <h3>DEMO ESCAPING- BOTH JSTL EL with fn:escapeXml & COUT avoid XSS BUT with ONLY EL get XSS!!!   </h3>
   
    <b>JSTL c:out EXAMPLE NO XSS--  </b><br>
     <c:out value="${test}"></c:out>
     <br><br>
     <b>EL ESCAPED[fn:escapeXml] EXAMPLE NO XSS-- </b><br>
      ${fn:escapeXml(test)} 
     <br><br>
     <b>  PLAIN EL EXAMPLE - OOPS XSS! 'ESCAPED' javascript  shows in ALERT--  </b> <br>
     ${test}
    
    
</body>
</html>
