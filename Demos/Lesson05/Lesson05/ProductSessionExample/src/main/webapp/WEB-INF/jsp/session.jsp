<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Session</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">
</head>
<body>
<div id="global">
    <h2 style="text-align: center;">${appName }</h2>
    <h4>This is the SessionController Page...</h4>
 
 
   <form action="product" method="get">
           <input id="submit" type="submit"  
                value="Go to add Product">
</form>
  
 </body>
</html>