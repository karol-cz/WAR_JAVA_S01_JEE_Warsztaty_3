<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		Solution detail:
		${solution.id}
		${solution.description}
	</div>
	<p><a href="http://localhost:8080/Warsztaty_3-Servlety/welcome">back</a></p>

</body>
</html>