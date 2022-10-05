<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background: #e2e2e2;">
	<div class="container d-flex align-items-center  justify-content-center" style="height: 600px;width: 1000px;">
		<div class="card mt-5">
			<div class="card-body" style="height: 500px;width: 900px;">
				<form action="/doregister" method="post">
				<h2 class="text-center">Registration</h2>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Name :</label>
				    <input type="text" name="empName" class="form-control" id="" aria-describedby="emailHelp" placeholder="Enter Full Name">
				    
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email Id :</label>
				    <input type="email" class="form-control" name="username" id="email" aria-describedby="emailHelp" placeholder="Enter Email">
				    
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password</label>
				    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
				  </div>
				  
				  <div class="text-center">
				  	<button type="submit" class="btn btn-primary">Submit</button>
				  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  	<a class="btn btn-success text-light" href="/login">Already have a account?</a>
				  </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>