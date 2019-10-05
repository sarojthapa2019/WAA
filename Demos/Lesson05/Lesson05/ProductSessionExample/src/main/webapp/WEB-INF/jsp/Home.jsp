<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">
</head>
<body>

	<div id="global">
		<h2 style="text-align: center;">${appName }</h2>
		

		<form action="forward" method="get">
			<input id="submit" type="submit" value="Forward">
		</form>
		<form action="getSession" method="get">
			<input id="submit" type="submit" value="Session">
		</form>
		<form action="redirect" method="get">
			<input id="submit" type="submit" value="Redirect">
		</form>
		<form action="product" method="get">
			<input id="submit" type="submit" value="PRG">
		</form>

		<form action="cookie" method="get">
			<input id="submit" type="submit" value="Cookies">
		</form>

	</div>
</body>
</html>
