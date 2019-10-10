<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Not Found</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<section>
	<div class="jumbotron">
		<div class="container">
			<h1 class="alert alert-danger">${msg}</h1>
		</div>
	</div>
	</section>

	<section>
		<div class="container">
			<p>${url }</p>
			<p>${exception }</p>
		</div>
		<div class="container">
			<p>
				<a href="<spring:url value="/products"/>" class="btn btn-primary"><span class="glyphicon-shopping-cart glyphicon"></span>products</a>
			</p>
		</div>
	</section>
	

</body>
</html>