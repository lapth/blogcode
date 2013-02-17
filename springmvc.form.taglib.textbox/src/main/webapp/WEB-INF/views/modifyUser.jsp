<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - TextBox</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/textbox/modifyUser" method="POST" commandName="user">
        	<table>
			    <tr>
			        <td><form:label path="name">User Name</form:label></td>
			        <td><form:input path="name" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="about">About</form:label></td>
			        <td><form:textarea path="about" cols="15" rows="4"/></td>
			    </tr>
			    <tr>
			    	<td><form:hidden path="hidden"/> </td>
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Update" />
			        </td>
			    </tr>
			</table>			    
        </form:form>
    </body>
</html>
