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
		<a href="http://localhost:8080/Warsztaty_3-Servlety/groupsAdminPanelAddNew">+ Add new Group</a>
	</div>
	<div>
		USERS LIST:
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
		</table>

		<table>
			<c:forEach var="g" items="${groups}">
				<tr>
					<th>${g.id}</th>
					<th>${g.name}</th>
					<th><a href="groupsAdminPanelEdit?id=<c:out value="${g.id}"/>">Edit</a></th>
					<th><a href="groupsAdminPanelDelete?id=<c:out value="${g.id}"/>">Delete</a></th>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>