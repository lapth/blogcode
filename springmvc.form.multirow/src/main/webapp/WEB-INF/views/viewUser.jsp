<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Binding Multi Row</title>
    </head>
    <body>
        <h1>User information</h1>
        <form:form action="/multirow/modifyUser" method="POST" modelAttribute="users">	
	       	<table border="1">
        		<tr>
        			<th>No</th>
        			<th>Name</th>
        			<th>Hobbies</th>
        			<th>Sex</th>
        			<th>Country</th>
        		</tr>
        		<c:forEach items="${users.lstUser}" var="user" varStatus="loopStatus">
				    <tr>
				    	<td>${loopStatus.index} </td>
				    	
				        <td>${user.name}</td>

				        <td>
					        <c:forEach items="${user.hobbies}" var="hobby">
								[<c:out value="${hobby}" />]
							</c:forEach>
						</td>

				        <td>
				        	${user.sex}
			        	</td>
						
						<td>
							<c:forEach items="${user.countries}" var="country">
								[<c:out value="${country}" />]
							</c:forEach>
						</td>
				    </tr>
			    </c:forEach>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="Update" />
			        </td>
			    </tr>
			</table>	
        </form:form>
    </body>
</html>
