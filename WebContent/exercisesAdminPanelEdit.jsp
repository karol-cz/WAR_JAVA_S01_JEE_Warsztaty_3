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
	
		<form action="exercisesAdminPanelEditSubmit" method="post">
			<input type="text" name="id" value="<c:out value="${exerciseId}"/>" readonly>
			<input type="text" name="title" placeholder="Title">
			<input type="text" name="description" placeholder="Description">
			<input type="submit" value="Zatwierdź">
		</form>

	</div>

</body>
</html>