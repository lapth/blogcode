<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - Radio</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/radio/modifyUser" method="POST" commandName="user">
        	<table>
			    <tr>
			        <td><form:label path="sex">Sex</form:label></td>
			        <td>
			        	Male:<form:radiobutton path="sex" value="M"/>
			        	Female:<form:radiobutton path="sex" value="F"/>
			        </td>
			    </tr>
			    <tr>
			    	<td><form:label path="skin">Skin</form:label></td>
			    	<td><form:radiobuttons path="skin" items="${lstSkin}" /></td>
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
