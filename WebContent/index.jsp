<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/Warsztaty_3-Servlety/css/styles.css" />
<title>Programming School</title>
</head>

<body>
	<div>
		<%@	include file="header.jsp"%>
	</div>
	<div class="wrapper">
		<div class="title">
			<h1>List of ${numberOfRows} recent solutions</h1>
		</div>

		<div class="table-responsive">
			<table class="table">
				<thead>
				<tr>
					<th>exercise</th>
					<th>solution author</th>
					<th>creation date</th>
					<th></th>
					</tr>
				<tbody>
					<c:forEach var="li" items="${list}">
						<tr>
							<td>${exercises[li.exercise_id].title}
							<td>${users[li.users_id].name} ${users[li.users_id].surname}</td>
							<td>${li.created}</td>
							<td></td>
							<td><a href="solutionDetails?id=<c:out value="${li.id}"/>"
								class="btn btn-default" role="button">Details</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

</body>
</html>

