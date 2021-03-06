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
			<h1>List of all Exercises</h1>
		</div>
		<div>
			<a href="http://localhost:8080/Warsztaty_3-Servlety/exercisesAdminPanelAddNew" class="btn btn-default" role="button">+ Add new Exercise</a>
		</div>
		<div class="table-responsive">
			<table class="table"  >
				<thead>
					<th>id</th>
					<th>title</th>
					<th>description</th>
					<th></th>
					</tr>
				<tbody>
					<c:forEach var="e" items="${exercises}">
						<tr>
							<td> ${e.id}</td>
							<td>${e.title}</td>
							<td>${e.description}</td>
							<td><a href="exercisesAdminPanelEdit?id=<c:out value="${e.id}"/>" class="btn btn-default" role="button">Edit</a>
								<a href="exercisesAdminPanelDelete?id=<c:out value="${e.id}"/>"class="btn btn-default" role="button">Delete</a>
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


