<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Session Form</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">
</head>
<body>

	<div id="global">
		<h2 style="text-align: center;">${appName }</h2>
		<form action="postSession" method="post">
			<fieldset>
				<legend>This is the Session "GET FORM" page</legend>
				<p id="buttons">
					<input id="submit" type="submit" value="Submit Session Form">
				</p>
			</fieldset>
		</form>

		<form action="delegateSession" method="get">
			<input id="submit" type="submit" value="Delegate Session Controller">
		</form>

		<form action="home" method="get">
			<input id="submit" type="submit" value="Go to Home">
		</form>

	</div>
	
</body>
</html>
