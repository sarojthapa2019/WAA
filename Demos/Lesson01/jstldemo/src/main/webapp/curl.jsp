<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>C:URL</title>
</head>
<body>
 
 <a href="/JSTL/curl.do?text=c:url- 25 Percent&hiddenfield=Hide&category=Computer Software">Working Regular URL - 'text' parameter has No SPECIAL Characters</a>
 <br><br>

<!-- Drops info due to special character % -->
 <a href="http://localhost:8080/JSTL/curl.do?text=c:url- 25%&hiddenfield=Hide&category=Computer Software">Failing Regular URL - DUE to SPECIAL Characters in 'text' parameter</a>
 <br><br>

<!--
 Does URL relative to context  Root
  Does URL encoding...of the following special characters
" ","%","#","<",">","{", "}", "|", "\", "^", "~", "[", "]", and "`"
 -->
<c:url var="cURL" value="/curl.do">
   <c:param name="text" value="c:url- 25%"/>
   <c:param name="hiddenfield" value="Hide"/>
   <c:param name="category" value="Computer Software"/>
</c:url>

<!-- To show the url, do this -->

<a href="${cURL}">C:URL to ENCODE Special Characters in 'text' parameter </a>

<p>SEE CONSOLE for 'text' parameter values delivered to server</p>


        <br></br>
        <a href="PublicFacade.jsp">Home</a>

</body>
</html>
