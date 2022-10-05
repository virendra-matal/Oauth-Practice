
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body style="background: #e2e2e2;">
	<div class="container text-center mt-5 d-flex align-items-center  justify-content-center" style="height: 500px;width: 1000px;">
		<div class="card mt-5">
			<div class="card-body" style="height: 350px;width: 900px;">
				<h1>Welcome Mr. ${loggedInUser.empName}.</h1>
				<a class="btn btn-success mt-5" href="/logout">Logout</a>
			</div>
		</div>
	</div>
</body>
</html>