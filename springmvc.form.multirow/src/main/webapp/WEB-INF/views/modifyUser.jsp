<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
        <title>Form Binding - Multi Row</title>
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
				    	<td>${loopStatus.index}</td>
				    	<!-- text box -->
				        <td>
				        	<spring:bind path="users.lstUser[${loopStatus.index}].name">
				        		<input 
				        			type="text" 
				        			name="<%=status.getExpression() %>"
				        			value="<%=status.getValue() %>"
				        			/>
				        		<span class="errors"><c:out value="${status.errorMessage }" /></span>	
				        	</spring:bind>
						</td>
						<!-- multi check box -->
						<td>
							<spring:bind path="users.lstUser[${loopStatus.index}].hobbies">
								<c:forEach items="${lstHobby}" var="hobby">
									<c:set var="checkMe" value="" />
									<c:forEach items="${status.actualValue}" var="curValue">
										<c:if test="${curValue == hobby.value}">
											<c:set var="checkMe" value="checked" />
										</c:if>
									</c:forEach>
									<input 
					        			type="checkbox" 
					        			name="<%=status.getExpression() %>"
				        				value="${hobby.value}"
				        				<c:out value="${checkMe }"/>
				        			/>${hobby.label }
								</c:forEach>
				        	</spring:bind>
						</td>
						<!-- radio button -->
						<td>
							<c:set var="male" value="M"/>
							<c:set var="female" value="F"/>
							<spring:bind path="users.lstUser[${loopStatus.index}].sex">
								<input 
									type="radio"
									name="<%=status.getExpression()%>"
									value="${male }"
									<c:if test="${male == status.value }">checked</c:if>
								/>Male
								<input 
									type="radio"
									name="<%=status.getExpression()%>"
									value="${female }"
									<c:if test="${female == status.value }">checked</c:if>
								/>Female
								<div><c:out value="${status.errorMessage }" /></div>
							</spring:bind>
						</td>
						<!-- select -->
						<td>
							<spring:bind path="users.lstUser[${loopStatus.index}].countries">
								<select name="<%=status.getExpression() %>">
									<option value="NONE">---SELECT---</option>
									<c:forEach items="${lstCountry }" var="country">
										<c:set var="selectMe" value="" />
										<c:forEach items="${status.actualValue}" var="curValue">
											<c:if test="${curValue == country.value}">
												<c:set var="selectMe" value="selected" />
											</c:if>
										</c:forEach>
										<option 
											value="${country.value }"
											${selectMe } 
										>
											${country.label }
										</option>
									</c:forEach>
								</select>
							</spring:bind>
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
