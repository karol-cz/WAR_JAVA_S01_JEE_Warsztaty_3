<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
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
				Details of <b>${user.name}</b>
			</h1>
		</div>
		
		<div class="list_1">
			ID:<br /> 
			NAME:<br /> 
			SURNAME:<br /> 
			EMAIL:<br /> 
			PASSWORD:<br /> 
			GROUP ID:<br />
		</div>
		<div class="list_2">
			${user.id}<br /> 
			${user.name}<br />
			${user.surname}<br /> 
			${user.email}<br />
			${user.password}<br />
			${user.person_group_id}<br />
		</div>



		<div class="back_button">
			<a
				href="http://localhost:8080/Warsztaty_3-Servlety/usersShort?groupId=<c:out value="${groupId}"/>" class="btn btn-default" role="button">Back</a>
		</div>
	</div>


</body>
</html>
