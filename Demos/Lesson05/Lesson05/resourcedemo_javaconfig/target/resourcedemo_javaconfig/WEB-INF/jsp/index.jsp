<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>${appName}</title>
    <link rel="stylesheet" href="<c:url value="/myresources/css/main.css"/>">
</head>
<body>
<div id="global">
    <h2>Application Context Attribute: <c:out value="${appName}"></c:out> </h2>

    <h2>Application Init Parameter:${initParam["spring.profiles.default"]}</h2>

    <!--The below image will show correctly, because addResourceHandlers() methods in WebApplicationContextConfig.java-->
    <img src="<c:url value="/myresources/Puppet404.gif"/>">

    <!--The below image will show correctly, because configureDefaultServletHandling() methods in WebApplicationContextConfig.java,
     This is the default settings, which URL Mapps to the project structure.-->
    <img src="<c:url value="/myresources/new/error_page.jpg"/>">
</div>
</body>
</html>
