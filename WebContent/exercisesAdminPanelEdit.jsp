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
			<h1>Edit Exercise</h1>
		</div>
		<form class="form-horizontal" action="exercisesAdminPanelEditSubmit" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2">id:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="id" value="<c:out value="${exerciseId}"/>" readonly>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">title:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="title" placeholder="Enter title">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">description:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="description" placeholder="Enter description">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>

		</form>

	</div>

</body>
</html>
