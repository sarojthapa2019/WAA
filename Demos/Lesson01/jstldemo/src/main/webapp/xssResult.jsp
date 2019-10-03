<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--Ignores Script BECAUSE
c:out escapes HTML characters to avoid cross-site scripting.
-->
<b>With C:OUT Ignores Script:</b><br/>
Your Search Results for : <c:out value="${inputTest }"></c:out>  <br/>

<p>
  <b> WITHOUT  C:OUT -- [HACKED!! Executes javascript!!!]:</b><br/>
  Your Search Results for : ${inputTest } 
</p> 


</body>
</html>