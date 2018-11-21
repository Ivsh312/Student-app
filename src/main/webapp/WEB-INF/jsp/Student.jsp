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
	<div class="form-buttom">

		<div style="width: 341px;">

			<form action="/student-app/student" onsubmit="eventClic(event)"
				class="container-custom2" style="width: 343px;">
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
		<div>

			<a href="nstudent">new student</a>

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

	<script type="text/javascript">
		function eventClic(e) {
			if (e) {
				e.preventDefault();
			}

			var body, tab, tr, td, tn, row, col, firstNameFiltr, secondnameSortFiltr, groupNumberFiltr;
			firstNameFiltr = document.getElementsByName('firstNameFiltr')[0].value;
			secondnameSortFiltr = document
					.getElementsByName("secondnameSortFiltr")[0].value;
			groupNumberFiltr = document.getElementsByName('groupNumberFiltr')[0].value;
			body = document.getElementsByTagName('tbody')[0];

			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/student-app/studentGetJsin?'
					+ addParam('firstNameFiltr', firstNameFiltr)
					+ addParam('secondnameSortFiltr', secondnameSortFiltr)
					+ addParam('groupNumberFiltr', groupNumberFiltr), true);
			xhr.send();
			if (xhr.readyState != 4)
				return;
			if (xhr.status != 200) {

				alert(xhr.status + ': ' + xhr.statusText);
			} else {

				var data = JSON.parse(xhr.responseText);
				var table = createTable(data);

			}

			function createTable(data) {
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

					td = document.createElement('td');
					tn = document.createTextNode(ob.groupNumber);
					td.appendChild(tn);
					tr.appendChild(td);
					body.appendChild(tr);
				}
			}
		}
		function addParam(field, value) {
			return field + "=" + value + "&";
		}
		eventClic();
	</script>

</body>
</html>