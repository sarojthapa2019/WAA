<%--
  Created by IntelliJ IDEA.
  User: SarojThapa
  Date: 9/30/2019
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Starbuck's ${roast} Roast Coffees:</h1>
<table>
<c:forEach var="roas" items="${advices}" varStatus="i" >
<c:if test="${i.count%2==0}" >
    <tr style="background-color: aquamarine">
</c:if>

        ${roas}
    </tr>
    <br/>
</c:forEach>
</table>

</body>
</html>
