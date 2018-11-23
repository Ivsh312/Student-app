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
			<li class="list-group-item"><a href=# onclick="logout()">Log
					out</a>
		</ul>
	</div>
	<div class="form-buttom">

		<div class="my-div-form">
			<form onsubmit="eventClic(event)" class="container-custom2"
				style="width: 343px;">
				<div class="container-custom">
					<div class="form-group">
						<label>name Subject</label> <input type='text' name='nameSubF'
							class="form-control">
					</div>
					<div class="form-group">
						<label>hours</label> <input type='text' name='hoursF'
							class="form-control">
					</div>
					<div class="form-group">
						<label>avgMark</label> <input type='text' name='avgMarkF'
							class="form-control">
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
						<label>name Subject</label> <input type='text' name='nameSub'
							class="form-control">
					</div>
					<div class="form-group">
						<label>hours</label> <input type='text' name='hours'
							class="form-control">
					</div>
					<div class="form-group">
						<label>avgMark</label> <input type='text' name='avgMark'
							class="form-control">
					</div>
				</div>
				<button class="btn btn-success">Add New Subject</button>
			</form>

		</div>

	</div>

	<div class="div-table">
		<table class="table table-border table-hover">
			<thead>
				<th>name Subject</th>
				<th>hours</th>
				<th>avgMark</th>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/myjsSubject.js"></script>

</body>
</html>