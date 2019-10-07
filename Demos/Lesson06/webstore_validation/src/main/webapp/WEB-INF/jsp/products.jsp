
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Products</h1>
			<p>All the available products in our store</p>
		</div>
	</div>
	</section>
	
	<section class="container">
		<div class="row">
		<c:forEach items="${products }" var="product">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.name }</h3>
						<p>${product.description }</p>
						<p>${product.unitPrice } USD</p>
						<p>Available ${product.unitsInStock } units in stock</p>
						<p><a href="<spring:url value="/product?id=${product.productId }" />" class="btn btn-primary"><span class="glyphicon-shopping-cart glyphicon"></span>Details</a></p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>