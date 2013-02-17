<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - Errors</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/jsr303/modifyUser" method="GET" commandName="user">	
	       	<table>
			    <tr>
			        <td width="100px">First Name</td>
			        <td>${user.firstName}</td>
			    </tr>
			    <tr>
			        <td>Last Name</td>
			        <td>${user.lastName}</td>
			    </tr>
			    <tr>
			        <td>Code</td>
			        <td>${user.code}</td>
			    </tr>
			    <tr>
			        <td>Password</td>
			        <td>${user.password}</td>
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Modify" />
			        </td>
			    </tr>
			</table>
        </form:form>
    </body>
</html>
