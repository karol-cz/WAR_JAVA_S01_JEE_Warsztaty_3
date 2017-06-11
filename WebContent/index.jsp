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
		<table>
		<tr>
			<th>id</th>
			<th>user id</th>
			<th>creation date</th>
			<th></th>
		</tr>
		<c:forEach var="li" items="${list}">
			<tr>
				<th>${li.id}</th>
				<th>${li.description}</th>
				<th>${li.created}</th>
				<th><a href="solutionDetails?id=<c:out value="${li.id}"/>">Details</a>
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>