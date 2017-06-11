<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@	include file="header.jsp"%>
	</div>
	<div>
		<p>DETAILS OF USER: ${user.name}</p>
		Nazwisko: ${user.surname} Email: ${user.email}
	</div>
	<div>
		<table>
			<c:forEach var="sl" items="${solutionsList}">
				<tr>
					<th>${sl.description}</th>
					<th>${sl.created}</th>
					<th><a href="solutionById?id=<c:out value="${sl.id}"/>&groupId=<c:out value="${groupId}"/>&userId=<c:out value="${user.id}"/>">Details</a>
				</tr>
			</c:forEach>
		</table>

	</div>
	<p><p>
		<a
			href="http://localhost:8080/Warsztaty_3-Servlety/usersShort?groupId=<c:out value="${groupId}"/>">back</a>
	</p>


</body>
</html>