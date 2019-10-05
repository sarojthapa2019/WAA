<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<title>Starbuck's</title>
</head>
<body>
<h2>Hello ${user.name}</h2>
<h2>Ask for advice about your favorite roast:</h2>

<form action = "advice.do" method="post">
<select name="type"   >

	  		<c:forEach var="roast" items="${roasts}">
	    		<option value="${roast}" > ${roast}</option>
			</c:forEach>

</select>

<p><input type="submit" value = "Submit"/></p>
</form>
<div>
	<form action="logout" method="get">
		<input type = "submit" value = "Logout"/>
	</form>
</div>
 </body>
</html>
