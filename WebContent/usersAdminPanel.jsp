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
		<%@	include file="headerAdminPanel.jsp"%>
	</div>
	
	<div class="wrapper">
		<div class="title">
			<h1>List of all Users</h1>
		</div>
		<div>
			<a href="http://localhost:8080/Warsztaty_3-Servlety/usersAdminPanelAddNew" class="btn btn-default" role="button">+ Add new User</a>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>id</th>
					<th>name</th>
					<th>surname</th>
					<th>email</th>
					<th>group id</th>
					<th></th>
					</tr>
				<tbody>
					<c:forEach var="u" items="${users}">
						<tr>
							<td>${u.id}</td>
							<td>${u.name}</td>
							<td>${u.surname}</td>
							<td>${u.email}</td>
							<td>${u.person_group_id}</td>
							<td><a href="usersAdminPanelEdit?id=<c:out value="${u.id}"/>" class="btn btn-default" role="button">Edit</a>
								<a href="usersAdminPanelDelete?id=<c:out value="${u.id}"/>" class="btn btn-default" role="button">Delete</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div>											
	</div>

	
</body>
</html>
