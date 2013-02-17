<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - Radio</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/radio/modifyUser" method="GET" commandName="user">	
	       	<table>
			    <tr>
			        <td width="100px">Sex</td>
			        <td>${user.sex }</td>
			    </tr>
			    <tr>
			    	<td>Skin</td>
			    	<td>${user.skin }</td>
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
