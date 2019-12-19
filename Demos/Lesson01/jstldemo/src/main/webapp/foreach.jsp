<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>For Each</title>
</head>
<body>

<%! ArrayList<String> list = new ArrayList<String>(); %>
<%
//set things up
list.add("Jim");
list.add("Bob");
list.add("Harold");
list.add("Suzie");
request.setAttribute("list", list);

request.setAttribute("ignoreIt", "Bob");


%>
<h3>Test list is Jim, Bob, Harold, Suzie</h3>

<h4>forEach populating a table IGNORING Bob</h4>
<table border = '1'>
<c:forEach var="personsname" items = "${list}">
	<c:if test = "${ignoreIt ne personsname }">
		<tr><td>${personsname}</td></tr>
	</c:if>

</c:forEach>
</table>	


<p>
<h4>INDEXED forEach populating a select with PARTIAL list</h4>
    <select name= "vendorIndex">	
	  	<c:forEach var="i" begin="1" end="2">
		    <option value="${i}" > ${list[i]} </option>   
 	 	</c:forEach>
    </select>
</p>


<%! ArrayList<String> musicList = new ArrayList<String>(); %>
<%
//set things up
musicList.add("Sonata");
musicList.add("Fugue");
musicList.add("Opus");
musicList.add("Concerto");
request.setAttribute("musicList", musicList);
request.setAttribute("skipIt", "Fugue");

%>

<h3>Test list is Sonata, Fugue, Opus, Concerto </h3>

<h4>forEach using c:out INSTEAD of EL ignoring Fugue</h4>


<c:forEach var="musicPiece" items = "${ musicList }">
	<c:if test = "${ skipIt ne musicPiece }">
		    <c:out value="${musicPiece}"></c:out><br>		     
</c:if>
</c:forEach>
 	
<%
Map< String, String > categoryMap = new HashMap<String, String>();

	categoryMap.put("Computers", "Computer");
			categoryMap.put("Shoes", "Shoes");
			categoryMap.put("TVs", "Television");
	        categoryMap.put("Housewares", "HouseWares");
 
	        request.setAttribute("categoryMap", categoryMap);
%>

  <h4>Select WITH map example... </h4>
 	<p>
		<select name="category">
	    	<option value="-">  --Select category </option>
	
	  		<c:forEach var="category" items="${categoryMap}">
	    		<option value="${category.key}" > ${category.value}</option>
			</c:forEach>
	    </select>
	</p>

 




</body>
</html>