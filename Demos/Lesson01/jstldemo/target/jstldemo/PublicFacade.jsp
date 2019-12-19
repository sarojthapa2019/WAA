<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Now You See It, Now You Don't</title>
<style type="text/css">@import url(css/css.css);</style>
</head>
<body>

 <!-- This "URL" is relative to the WebContent - in WEB-INF/JSPs folder -->
        <a href="WEB-INF/JSPs/PrivPub.jsp" >We are in "public" area - No Access to WEB-INF [ private area] </a>
        <br></br>


<!-- Here's our form -->
<form action="offon.do" method="get"><br/>

<!-- IF STATEMENT used to set checkbox....-->
 <H3>    JSTL IF & Choose examples    </H3>

<!-- See https://proto.io/freebies/onoff/ for original source code for switch -->
    <h4>This ON/OFF  maintains state via C:IF</h4>
	<div class="onoffswitch">
		       <!-- onOff attribute set in ControllingServlet  'on' is default for checked - if no value set-->
	    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" 
	        <c:if test="${onOff eq 'on'}">checked=checked</c:if> 
	    >
	    <label class="onoffswitch-label" for="myonoffswitch">
	        <span class="onoffswitch-inner"></span>
	        <span class="onoffswitch-switch"></span>
	    </label>
	</div>
	
    <h4>This one has no C:IF logic to maintain state - ALWAYS OFF</h4>
	<div class="onoffswitch">
	    <input type="checkbox" name="offswitch" class="onoffswitch-checkbox" id="myoffswitch" 
 	    >
	    <label class="onoffswitch-label" for="myoffswitch">
	        <span class="onoffswitch-inner"></span>
	        <span class="onoffswitch-switch"></span>
	    </label>
	</div>
	
 
<!-- This is how to implement 'if/else'  
         CHOOSE - works like a java SWITCH statement With BREAK
         WHEN is like CASE
         OTHERWISE is like DEFAULT -->
<!-- this code is figuring out the button value 
       AND "maintaining state" - hidden value - for next request cycle-->
<c:choose>
  <c:when test="${hidden eq 'Hide'}">
     <c:set var = "hiddenvalue" value="Show" />
     <c:set var = "buttonvalue" value="Show text field" />
  </c:when>
  <c:otherwise>
    </br>We will Toggle This TEXT based on C:CHOOSE!!!!
     <c:set var = "hiddenvalue" value="Hide" />
     <c:set var = "buttonvalue" value="Remove text field" />
  </c:otherwise>
</c:choose>
	
	<p>	 
		<input type = "submit" value ="${buttonvalue}"/>
		<input type = "hidden" name = "hiddenfield" value = '${hiddenvalue}'/>
    </p>	
	
</form>
</br>


<p>

 <H3>    Further JSTL examples    </H3>
 <!-- These "URLs" are relative to the WebContent folder  -  they are in WebConent/-->
        <a href="foreach.jsp" >c:foreach</a>
        <br></br>
        <a href="curl.jsp">c:url</a>
         <br></br>
        <a href="xssTest.jsp">XSS via Input</a>
         <br></br>
        <a href="setAndOut.jsp">c:out</a>
         <br></br>
         <a href="format.jsp">format Number</a>
        <br></br>
        <a href="function.jsp">String Function</a>
 </p>
 
 
  ${UrlScript } 
</body>
</html>