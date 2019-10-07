<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">
</head>
<body>
<div id="global">
    <h2 style="text-align: center;">${appName }</h2>
    <h4>- ${param.name} !! - The product has been saved.</h4>
         <h5>Details:</h5>
   <p> 
<c:choose>
  <c:when test="${product eq null}">
     The Product details are not available
  </c:when>
  <c:otherwise>
    <p> 
         Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
  
    </c:otherwise>
</c:choose>
*****${test }====
      <form action="product" method="get">
           <input id="submit" type="submit"  
                value="Go to Product">
	</form>
    
</div>
</body>
</html>