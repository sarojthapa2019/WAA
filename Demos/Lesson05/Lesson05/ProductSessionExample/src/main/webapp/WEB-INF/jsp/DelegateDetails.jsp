<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">

</head>
<body>
<div id="global">
     <h4>This is the DELEGATE Session GET display</h4>
     <h5>We have Removed @SessionAttributes - Donatello & Leonardo </h5>
     <h5> They will be missing when "Go To Session" is clicked</h5>
       <form action="getSession" method="get">
           <input id="submit" type="submit"  
                value="Go to Session">
	</form>
    
</div>
</body>
</html>