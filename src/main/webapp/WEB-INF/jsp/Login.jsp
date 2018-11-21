<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
<div class=" form-group-my">
   <form action="/student-app/login" method="POST"
		class="container-custom2 ">
		<div class="container-custom">
			<div class="form-group">
				<label>Login</label> <input type='text' name='user'
					class="form-control">
			</div>
			<div class="form-group">
				<label>Password</label> <input type='text' name='pass'
					class="form-control">
			</div>
			<button class="btn btn-success">Send</button>
		</div>
	</form>
 </div>  
</body>
</html>