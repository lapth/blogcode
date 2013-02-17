<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - CheckBox</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/checkbox/modifyUser" method="POST" commandName="user">
        	<table>
			    <tr>
			        <td><form:label path="married">Married</form:label></td>
			        <td><form:checkbox path="married" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="hobbies">Hobbies</form:label></td>
			        <td><form:checkboxes path="hobbies" items="${lstHobby}" /> </td>
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
