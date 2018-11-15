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
	<form action="/student-app/studentAll" method="POST"
		class="container-custom2">
		<button class="btn btn-success">Delete</button>
		<div class="div-table">
			<table class="table table-border table-hover">
				<thead>
					<th>FersName</th>
					<th>SecondName</th>
					<th>mark to delete</th>
				</thead>
				<tbody>
					<c:forEach items="${Students}" var="student">
						<tr>
							<td>${student.firstName}</td>
							<td>${student.secondName}</td>
							<td><input type="checkbox" name="id" value="${student.id}">
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	<li role="presentation" class="active">
	<a href="http://localhost:9090/student-app/studentAdd">Add Student</a></li>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>