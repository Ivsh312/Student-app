<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored='false'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/student-app/test" method="POST">
		<input type="text" name="firstName"> <input type="text"
			name="secondName"> <input type="submit" value="OK">
	</form>
	<table>
		<thead>
			<tr>
				<th>First name</th>
				<th>Second name</th>

			</tr>
		</thead>
		<tbody id="tbody"></tbody>
	</table>

	<script type="text/javascript">
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/student-app/test?json', false);
		xhr.send();

		if (xhr.status != 200) {

			alert(xhr.status + ': ' + xhr.statusText);
		} else {

			var data = JSON.parse(xhr.responseText);

		}

		var body, tab, tr, td, tn, row, col;

		body = document.getElementsByTagName('tbody')[0];

		for (row = 0; row < data.length; row++) {

			tr = document.createElement('tr');
			var ob = data[row];
			td = document.createElement('td');
			tn = document.createTextNode(ob.firstName);
			td.appendChild(tn);
			tr.appendChild(td);

			td = document.createElement('td');
			tn = document.createTextNode(ob.secondName);
			td.appendChild(tn);
			tr.appendChild(td);
			body.appendChild(tr);
		}
	</script>
	<form action="/student-app/test" method="POST">
		<input type="text" name="firstName"> <input type="text"
			name="secondName"> <input type="submit" value="OK">
	</form>
	
	
	<script type="text/javascript">
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/student-app/test?json', false);
		xhr.send();

		if (xhr.status != 200) {

			alert(xhr.status + ': ' + xhr.statusText);
		} else {

			var data = JSON.parse(xhr.responseText);

		}

		var body, tab, tr, td, tn, row, col;

		body = document.getElementsByTagName('tbody')[0];

		for (row = 0; row < data.length; row++) {

			tr = document.createElement('tr');
			var ob = data[row];
			td = document.createElement('td');
			tn = document.createTextNode(ob.firstName);
			td.appendChild(tn);
			tr.appendChild(td);

			td = document.createElement('td');
			tn = document.createTextNode(ob.secondName);
			td.appendChild(tn);
			tr.appendChild(td);
			body.appendChild(tr);
		}
	</script>
	

</body>
</html>