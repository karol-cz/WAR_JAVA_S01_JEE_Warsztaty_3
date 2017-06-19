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
			<h1>Create new Solution</h1>
		</div>
		<form class="form-horizontal" action="solutionsAdminPanelEditSubmit" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2">id:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="id" value="<c:out value="${solutionId}"/>" readonly>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">title:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="created" placeholder="YYYY-MM-DD">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">description:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="updated" placeholder="YYYY-MM-DD">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">description:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="description" placeholder="Enter description">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">exercise id:</label>
				<div class="col-sm-6">
					<select class="form-control" name="exercise_id">
						<c:forEach var="e" items="${exercises}">
							<option value="${e.id}">${e.id}, ${e.title} </option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">user id:</label>
				<div class="col-sm-6">
					<select class="form-control" name="users_id">
						<c:forEach var="u" items="${users}">
							<option value="${u.id}">${u.id}, ${u.name}  </option>
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
