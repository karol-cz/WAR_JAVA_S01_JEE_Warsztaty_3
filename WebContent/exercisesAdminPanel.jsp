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
		<a href="http://localhost:8080/Warsztaty_3-Servlety/exercisesAdminPanelAddNew">+ Add new Exercise</a>
	</div>
	<div>
		USERS LIST:
		<table>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
		</table>

		<table>
			<c:forEach var="e" items="${exercises}">
				<tr>
					<th>${e.id}</th>
					<th>${e.title}</th>
					<th>${e.description}</th>
					<th><a href="exercisesAdminPanelEdit?id=<c:out value="${e.id}"/>">Edit</a></th>
					<th><a href="exercisesAdminPanelDelete?id=<c:out value="${e.id}"/>">Delete</a></th>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>