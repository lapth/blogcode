<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - Select</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/selectt/modifyUser" method="POST" commandName="user">
        	<table>
			    <tr>
			    	<td><form:label path="skill1">Skill 1</form:label></td>
			    	<td><form:select path="skill1" items="${lstSkill}" itemValue="itemValue" itemLabel="itemLabel" /></td>
			    </tr>
			    <tr>
			    	<td><form:label path="skill2">Skill 2</form:label></td>
			    	<td>
				    	<form:select path="skill2">
				    		<form:option value="-" label="--Please Select"/>
				    		<form:options path="skill2" items="${lstSkill}" itemValue="itemValue" itemLabel="itemLabel" />
				    	</form:select>
			    	</td>
			    </tr>
			    <tr>
			    	<td><form:label path="skills">Skill Set</form:label></td>
			    	<td><form:select path="skills" items="${lstSkill}" multiple="true" itemValue="itemValue" itemLabel="itemLabel" /></td>
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
