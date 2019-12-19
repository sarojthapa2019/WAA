<%--
  Created by IntelliJ IDEA.
  User: SarojThapa
  Date: 9/30/2019
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Starbuck's</title>
</head>
<body>
<h2>Ask for advice about your favorite roast:</h2>
<p />
<form action = "advice" method="get">
    <select name="roast" >
        <option value="-">--Choose Roast--</option>
        <c:forEach var="key" items="${adviceKey}">
            <option value="${key}">${key}</option>
        </c:forEach>


<%--        <option value="medium">Medium</option>--%>
<%--        <option value="light">Light</option>--%>
    </select>

    
    <br/><br/>
    <input type="submit" value = "Submit"  />
</form>
<div id='advice'>

</div>
<p />

</body>
</html>
