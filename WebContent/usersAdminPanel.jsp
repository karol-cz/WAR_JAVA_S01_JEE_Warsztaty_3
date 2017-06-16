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
		<a href="http://localhost:8080/Warsztaty_3-Servlety/usersAdminPanelAddNew">+ Add new User</a>
	</div>
	<div>
		USERS LIST:
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Email</th>
				<th>Group ID</th>
			</tr>
		</table>

		<table>
			<c:forEach var="u" items="${users}">
				<tr>
					<th>${u.id}</th>
					<th>${u.name}</th>
					<th>${u.surname}</th>
					<th>${u.email}</th>
					<th>${u.person_group_id}</th>
					<th><a href="usersAdminPanelEdit?id=<c:out value="${u.id}"/>">Edit</a>
					<th><a href="usersAdminPanelDelete?id=<c:out value="${u.id}"/>">Delete</a>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>