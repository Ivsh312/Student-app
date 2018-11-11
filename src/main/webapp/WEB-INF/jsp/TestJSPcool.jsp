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
	<form action="/student-app/test" method="POST"
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
			<div class="form-group">
				<label>mark</label> <input type='text' name='mark'
					class="form-control">
			</div>
			<div class="form-group">
				<label>comments</label> <input type='text' name='comments'
					class="form-control">
			</div>
			<button class="btn btn-success">Send</button>
		</div>
	</form>
	<table class="table table-border table-hover">
		<thead>
			<th>FersName</th>
			<th>SecondName</th>
		</thead>
		<tbody>
			<c:forEach items="${Students}" var="student">
				<tr>

					<td>${student.firstName}</td>
					<td>${student.secondName}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
<table class="table table-border table-hover">
						<thead>
							<th>mark</th>
							<th>comments</th>
						</thead>
						<tbody>
							<c:forEach items="${Marks}" var="markStudent">
								<tr>
									<td>${markStudent.mark}</td>
									<td>${markStudent.comments}</td>
								</tr>
							</c:forEach>
							</td>
						</tbody>
					</table>
	
	
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>