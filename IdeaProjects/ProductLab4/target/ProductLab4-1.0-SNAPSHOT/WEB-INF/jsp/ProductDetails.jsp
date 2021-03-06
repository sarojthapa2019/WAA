<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<link rel="stylesheet" href="<spring:url value="/css/main.css"/> " >
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>

        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Category: ${product.category.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}

    <spring:url var="productList_url" value="/listproducts">
    </spring:url>
    <form action="${productList_url}" method="get">
           <input id="submit" type="submit"  
                value="List products">
	</form>
    
</div>
</body>
</html>
