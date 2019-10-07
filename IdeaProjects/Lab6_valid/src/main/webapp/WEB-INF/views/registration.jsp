<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

<h1>Registration Form</h1><br />
    
    <form:form modelAttribute="student" >
        <p>
            <form:errors path="*" cssStyle="color:red;"/>
        </p>
        <p>
            <label> First Name:
                <form:input path="firstName"/>
            </label>
                <div  style="text-align: center;">
                    <form:errors path="firstName" cssStyle="color : red;" />
                </div>

        </p>
        <p>
            <label> Last Name:
                <form:input path="lastName"/>
                <div  style="text-align: center;">
                    <form:errors path="lastName" cssStyle="color : red;" />
                </div>
            </label>
        </p>
        <p>
            <label> Email:
                <form:input path="email"/>
                <div  style="text-align: center;">
                    <form:errors path="email" cssStyle="color : red;" />
                </div>
            </label>
        </p>
        <p>
            <label>
                <form:select path="gender" >
                    <form:option value=" " label="--Select Gender--"/>
                    <form:options  items="${gender}" />
                </form:select>

                <div  style="text-align: center;">
                    <form:errors path="gender" cssStyle="color : red;" />
                </div>
            </label>
        </p>
        <p>
            <label> Birthday:
                <form:input path="birthday"/>
                <div  style="text-align: center;">
                    <form:errors path="birthday" cssStyle="color : red;" />
                </div>
            </label>
        </p>

            <h2>Phone</h2>
        <p>
        <label> Area Code:
            <form:input path="phone.area"/>
            <div  style="text-align: center;">
                <form:errors path="phone.area" cssStyle="color : red;" />
            </div>
        </label>
        </p>
        <p>
        <label> Prefix:
            <form:input path="phone.prefix"/>
            <div  style="text-align: center;">
                <form:errors path="phone.prefix" cssStyle="color : red;" />
            </div>
        </label>
        </p>
        <p>
        <label> Number:
            <form:input path="phone.number"/>
            <div  style="text-align: center;">
                <form:errors path="phone.number" cssStyle="color : red;" />
            </div>
        </label>
        </p>
        <p>

        <input type="reset" value="Reset" tabindex="4">
            <input type="submit" value="Register" tabindex="5">
        </p>

    </form:form>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
</body>
</html>
