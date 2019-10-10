<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
			</div>
			
		</div>
	</section>
	<section class="container">
		<div class="row">
				<div class="col-md-5">
					<p>
						<a href="<spring:url value="/freemarker" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Freemarker
					    </a>
	
						<a href="<spring:url value="/velocity" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Velocity
					    </a>

						<a href="<spring:url value="/thymeleaf" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Thymeleaf
					    </a>

						<a href="<spring:url value="/demo" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> Demo
					    </a>
					</p>    
				</div>
		</div>
	</section>
</body>
</html>
