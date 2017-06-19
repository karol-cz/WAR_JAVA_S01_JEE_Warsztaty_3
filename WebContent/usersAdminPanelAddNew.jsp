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
			<h1>Create new User</h1>
		</div>
		<form class="form-horizontal" action="usersAdminPanelAddNewSubmit" method="post">

			<div class="form-group">
				<label class="control-label col-sm-2">name:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="name" placeholder="Enter name">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">surname:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="surname" placeholder="Enter surname">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">email:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="email" placeholder="Enter email">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">password</label>
				<div class="col-sm-6">
					<input class="form-control" type="password" name="password" placeholder="Enter password">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">group id:</label>
				<div class="col-sm-6">
					<select class="form-control" name="person_group_id">
						<c:forEach var="u" items="${groups}">
							<option value="${u.id}">${u.id}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>

		</form>

	

</body>
</html>

