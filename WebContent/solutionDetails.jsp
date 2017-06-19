<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>Solution details</h1>
		</div>
		<div class="list_1">
			ID:<br /> DESCRIPTION:<br /> CREATION DATE:<br /> UPDATE DATE:<br />
		</div>
		<div class="list_2">
			${solution.id}<br /> ${solution.description}<br />
			${solution.created}<br /> ${solution.updated}<br />

		</div>
		<div class="back_button">
			<a href="http://localhost:8080/Warsztaty_3-Servlety/welcome"
				class="btn btn-default" role="button">Back</a>
		</div>
	</div>


</body>
</html>