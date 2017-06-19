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
			<h1>List of all Solutions</h1>
		</div>
		<div>
			<a href="http://localhost:8080/Warsztaty_3-Servlety/solutionsAdminPanelAddNew" class="btn btn-default" role="button">+ Add new Solution</a>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>id</th>
					<th>created</th>
					<th>updated</th>
					<th>description</th>
					<th>exercise id</th>
					<th>user id</th>
					<th></th>
					</tr>
				<tbody>
					<c:forEach var="s" items="${solutions}">
						<tr>
							<td>${s.id}</td>
							<td>${s.created}</td>
							<td>${s.updated}</td>
							<td>${s.description}</td>
							<td>${s.exercise_id}</td>
							<td>${s.users_id}</td>
							<td><a href="solutionsAdminPanelEdit?id=<c:out value="${s.id}"/>" class="btn btn-default" role="button">Edit</a>
								<a href="solutionsAdminPanelDelete?id=<c:out value="${s.id}"/>" class="btn btn-default" role="button">Delete</a>
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
