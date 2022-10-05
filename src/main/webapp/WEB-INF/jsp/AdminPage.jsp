<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="card mt-5">
			<div class="card-body">
			<h2 class="text-center">Votes</h2>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Candidate No.</th>
				      <th scope="col">Candidate Name</th>
				      <th scope="col">Vote Counts</th>
				    </tr>
				  </thead>
				  <c:forEach var = "i" items="${data}">
				  <tbody>
				    <tr>
				      <th scope="row"><c:out value = "${i.candidateId}"/></th>
				      <td><c:out value = "${i.candidateName}"/></td>
				      <td><c:out value = "${i.voteCounts}"/></td>
				    </tr>
				    
				  </tbody>
				  </c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>