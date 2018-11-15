<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored='false'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<form action="/student-app/student" method="POST"
		class="container-custom2">
		<div class="container-custom">
			<div class="form-group">
				<label>firstName</label> <input type='text' name='firstName'
					class="form-control">
			</div>
			<div class="form-group">
				<label>secondName</label> <input type='text' name='secondName'
					class="form-control">
			</div>
			<button class="btn btn-success">Send</button>
		</div>
	</form>

	<form action="/student-app/student" method="POST"
		class="container-custom2">
		<input type="hidden" name="action" value="delete"/>
		<div class="container-custom">
			<div class="form-group">
				<label>id</label> <input type='text' name='id' class="form-control">
			</div>
			<div class="form-group">
				<label>firstName</label> <input type='text' name='firstName'
					class="form-control">
			</div>
			<div class="form-group">
				<label>secondName</label> <input type='text' name='secondName'
					class="form-control">
			</div>
			<button class="btn btn-success">Up Date</button>
		</div>
	</form>

	<form action="/student-app/student" method="POST"
		class="container-custom2">
		<input type="hidden" name="action" value="put"/>
		<div class="container-custom">
			<div class="form-group">
				<label>id</label> <input type='text' name='id' class="form-control">
			</div>
			<button class="btn btn-success">Delete</button>
		</div>
	</form>

	<div class="div-table">
		<table class="table table-border table-hover">
			<thead>
				<th>FersName</th>
				<th>SecondName</th>
				<th>Id</th>
			</thead>
			<tbody>
				<c:forEach items="${Students}" var="student">
					<tr>

						<td>${student.firstName}</td>
						<td>${student.secondName}</td>
						<td>${student.id}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>