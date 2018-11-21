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
	<div class="top1">
		<ul class="hr list-group-item list-group">
			<li class="list-group-item"><a href="login">login</a></li>
			<li class="list-group-item"><a href="marks">marks</a></li>
			<li class="list-group-item"><a href="professors">professors</a></li>
			<li class="list-group-item"><a href="student">student</a></li>
		</ul>
	</div>
	<form action="/student-app/marks" method="POST"
	class="container-custom2">
		<div class="container-custom">
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
	<div class="div-table">
	<table class="table table-border table-hover">
		<thead>
			<th>marks</th>
			<th>comments</th>
		</thead>
		<tbody>
			<c:forEach items="${Marks}" var="marks">
				<tr>

					<td>${marks.mark}</td>
					<td>${marks.comments}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>