<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>ForwardRedirect</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">
</head>
<body>
	<div id="global">
		<h2 style="text-align: center;">${appName }</h2>
		
		<h4>This is Forward or Redirect.</h4>

		<h5>If this is Redirect. - we "automatically" have
			@RequestParam... if not disable spring default behavior</h5>
		<h4>${redirectParamTest}</h4>

		<h5>If this is Forward. - we should see Request Attribute...</h5>
		<h4>${requestAttribute.description}</h4>

		<form action="home" method="get">
			<input id="submit" type="submit" value="Go Home">
		</form>
	</div>
</body>
</html>