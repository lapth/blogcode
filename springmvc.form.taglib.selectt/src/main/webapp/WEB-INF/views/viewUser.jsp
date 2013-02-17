<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding - Select</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/selectt/modifyUser" method="GET" commandName="user">	
	       	<table>
			    <tr>
			        <td width="100px">Skill 1</td>
			        <td>${user.skill1 }</td>
			    </tr>
			    <tr>
			    	<td>Skill 2</td>
			    	<td>${user.skill2 }</td>
			    </tr>
			    <tr>
			    	<td>Skill Set</td>
			    	<td>
				    	<c:forEach items="${user.skills}" var="skill">
				    		[<c:out value="${skill }" />]
				    	</c:forEach>
			    	</td>
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
