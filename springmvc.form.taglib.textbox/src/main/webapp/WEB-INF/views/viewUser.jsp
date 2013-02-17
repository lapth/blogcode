<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - TextBox</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/textbox/modifyUser" method="GET" commandName="user">	
	       	<table>
			    <tr>
			        <td width="100px">User Name</td>
			        <td>${user.name}</td>
			    </tr>
			    <tr>
			        <td>About</td>
			        <td><form:textarea path="about" cols="15" rows="4" readonly="true"/></td>
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
