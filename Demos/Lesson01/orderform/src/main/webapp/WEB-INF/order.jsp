<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/mystyle.css">
<meta charset="ISO-8859-1">
 
</head>
<body>
<!-- THIS IS A NO-NO h1> <%= getServletConfig().getInitParameter("servletName") %>  </h1-->
<h1> <%= request.getAttribute("servletName") %>  </h1>
<!-- THIS IS A NO-NO- h1> <%= request.getServletContext().getInitParameter("applicationName") %>  </h1-->
<h1> <%= getServletContext().getAttribute("applicationName") %>  </h1>
 	<form  method="post">
		 <table> 
        	<tr> 
        		<td>Name:</td> 
        		<td><input name='name'/></td>
        	</tr>    	
			<tr>
        		<td>Address:</td> 
        		<td><textarea name='address' cols='40' rows='5'></textarea></td> 
        	</tr>  	
			<tr> 
				<td>Country:</td> 
				<td>
				<select name='country'> 
					<option>United States</option> 
					<option>Canada</option> 
				</select>
				</td>
			</tr>
			<tr> 
				<td>Delivery Method:</td>
				<td>
					<input type='radio'  name='deliveryMethod'  value='First Class'/>First Class
					<input type='radio' name='deliveryMethod' value='Second Class'/>Second Class
				</td> 
         	</tr> 
       
			<tr>
        		<td>Shipping Instructions:</td> 
        		<td><textarea name='instruction'  cols='40' rows='5'></textarea></td> 
         	</tr>
         	
          	<tr> 
        		<td>&nbsp;</td> 
        		<td><textarea name='instruction'  cols='40' rows='5'></textarea></td> 
        	</tr>
 
 			<tr> 
        		<td>Please send me the latest product catalog:</td> 
        
				<td><input type='checkbox'  name='catalogRequest'/></td> 
       		</tr>
       		
        	 <tr> 
        		<td>&nbsp;</td> 
       			<td>
                 	<input type='submit' value="Submit"/>
                 </td> 
        	</tr> 
        </table> 
         	
        	
	</form>
</body>
</html>