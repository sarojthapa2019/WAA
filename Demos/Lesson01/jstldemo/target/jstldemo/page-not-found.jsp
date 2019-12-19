<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<% response.setStatus(404); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>404 error</title>
  </head>
  <body>

<center>
<%--  EITHER of the following examples...work
   <img src="${pageContext.request.contextPath}/images/Puppet404.gif" alt="404 Error - Page not Found!"/>
 --%>
   <img src="<c:url value="/images/Puppet404.gif" />" alt="404 Error - Page not found."  />

 </center> 
  </body>
</html>