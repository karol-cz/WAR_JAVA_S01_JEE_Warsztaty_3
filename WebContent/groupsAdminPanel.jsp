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
			<h1>List of all Groups</h1>
		</div>
		<div>
			<a href="http://localhost:8080/Warsztaty_3-Servlety/groupsAdminPanelAddNew" class="btn btn-default" role="button">+ Add new Group</a>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>id</th>
					<th>name</th>
					<th></th>
					</tr>
				<tbody>
					<c:forEach var="g" items="${groups}">
						<tr>
							<td>${g.id}</td>
							<td>${g.name}</td>
							<td><a href="groupsAdminPanelEdit?id=<c:out value="${g.id}"/>" class="btn btn-default" role="button">Edit</a>
								<a href="groupsAdminPanelDelete?id=<c:out value="${g.id}"/>"class="btn btn-default" role="button">Delete</a>
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
