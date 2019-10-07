<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">

<meta http-equiv="Cache-control" content="no-store">
<meta HTTP-EQUIV="Expires" content="-1">
</head>
<body>

	<div id="global">
		<h2 style="text-align: center;">${appName }</h2>
		<form action="product" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<p>
					<label for="name">Product Name: </label> <input type="text"
						id="name" name="name">
				</p>
				<p>
					<label for="description">Description: </label> <input type="text"
						id="description" name="description">
				</p>
				<p>
					<label for="price">Price: </label> <input type="text" id="price"
						name="price">

				</p>
				<p>
					<label for="prgFlag">PRG Flag: </label> <input type="checkbox"
						id="prgFlag" name="prgFlag" checked="checked">

				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Add Product">
				</p>
			</fieldset>
		</form>

		<form action="home" method="get">
			<input id="submit" type="submit" value="Home">
		</form>

	</div>
</body>
</html>
