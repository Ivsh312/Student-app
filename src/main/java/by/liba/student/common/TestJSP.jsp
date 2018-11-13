<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored='false'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<form action="/student-app/test" method="POST">
		<input type='text' name='firstName'> <input type='text'
			name='secondName'> <input type='submit' value='NULL'>
	</form>
	<div>
		<table>
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
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>