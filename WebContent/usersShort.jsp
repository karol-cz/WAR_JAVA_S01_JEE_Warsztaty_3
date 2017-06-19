<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/Warsztaty_3-Servlety/css/styles.css" />
</head>
<body>
	<div>
		<%@	include file="header.jsp"%>
	</div>
	<div class="wrapper">
		<div class="title">
			<h1>
				List of all users from <b>${groupName}</b>
			</h1>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>name</th>
					<th></th>
					</tr>
				<tbody>
					<c:forEach var="u" items="${users}">
						<tr>
							<td>${u.name}</td>
							<td><a
								href="userDetails?id=<c:out value="${u.id}"/>&groupId=<c:out value="${groupId}"/>"
								class="btn btn-default" role="button">Details</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="back_button">
			<a
				href="http://localhost:8080/Warsztaty_3-Servlety/groups?groupId=<c:out value="${groupId}"/>"
				class="btn btn-default" role="button">Back</a>
		</div>
	</div>
</body>
</html>