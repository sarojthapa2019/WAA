<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Calculate</title>
</head>
<body>
<form action="calc2" method="get">
    <input type = "text" name = "add1" size = "2"  value = "<c:out value="${add1}"></c:out> " />+
    <input type = "text" name = "add2" value = "${add2}" size = "2"/>=<input type = "text" name = "sum" value = "${sum}"  size = "2" readonly/><br/>
    <input type = "text" name = "mult1" value = "${mult1}" size = "2"/>*
    <input type = "text" name = "mult2" value = "${mult2}"  size = "2"/>=<input type = "text" name = "product" value = "${product}"   size = "2" readonly/><br/>
    <input type = "submit" value = "Submit"/>

</form>
</body>
</html>