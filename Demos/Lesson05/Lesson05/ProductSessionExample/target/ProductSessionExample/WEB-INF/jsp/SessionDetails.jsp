<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<link rel="stylesheet" href="<c:url value="/resource/main.css"/>">
</head>
<body>
	<div id="global">
		<h4>This is the Session POST display</h4>
		<h5>We have Removed @SessionAttributes - Splinter and Leonardo</h5>
		<h5>They will be missing when "Go To Session" is clicked</h5>
		<form action="getSession" method="get">
			<input id="submit" type="submit" value="Go to Session">
		</form>

		<h5>We can still use the session Attribute Donatello --
			${Donatello} -- EVEN THOUGH he is NOT a @SessionAttribute!!!</h5>
			<p>Leonardo: ${Leonardo.name }</p>
			<p>Splinter: ${Splinter }</p>
	</div>
</body>
</html>