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
			<li class="list-group-item"><a href="subject">subject</a></li>
			<li class="list-group-item"><a href="professorsPage">professors</a></li>
			<li class="list-group-item"><a href="student">student</a></li>
			<li class="list-group-item"><a href=# onclick="logout()">Log out</a>
		</ul>
	</div>
	<div class="form-buttom">

		<div class="my-div-form">
			<form onsubmit="eventClic(event)" class="container-custom2"
				style="width: 343px;">
				<div class="container-custom">
					<div class="form-group">
						<label>firstName</label> <input type='text' name='firstNameFiltr'
							class="form-control">
					</div>
					<div class="form-group">
						<label>secondName</label> <input type='text'
							name='secondnameSortFiltr' class="form-control">
					</div>
					<div class="form-group">
						<label>group number</label> <input type='text'
							name='groupNumberFiltr' class="form-control">
					</div>
				</div>
				<button class="btn btn-success">Search</button>
			</form>
		</div>
		<div class="my-div-form">
			<form onsubmit="addStudent(event)" class="container-custom2"
				style="width: 343px;">
				<div class="container-custom">
					<div class="form-group">
						<label>firstName</label> <input type='text' name='firstName'
							class="form-control">
					</div>
					<div class="form-group">
						<label>secondName</label> <input type='text' name='secondname'
							class="form-control">
					</div>
					<div class="form-group">
						<label>group number</label> <input type='text' name='groupNumber'
							class="form-control">
					</div>
					<div class="form-group">
						<label>avg markr</label> <input type='text' name='avgMark'
							class="form-control">
					</div>
				</div>
				<button class="btn btn-success">Add New Student</button>
			</form>

		</div>

	</div>
	<div class="div-table">
		<table class="table table-border table-hover">
			<thead>
				<th>FersName</th>
				<th>SecondName</th>
				<th>Group</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/myjsStudent.js"></script>
</body>
</html>