<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>SMS-Add Student</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">SMS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="add">Add</a></li>
					<li class="nav-item"><a class="nav-link" href="getAll">All</a>
					</li>
				</ul>

			</div>
		</div>
	</nav>
	<br>

	<div class="card border-info mb-3">
		<div class="card-body">
			
			<br>
			<form action="update" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Roll_No</label>
					<input type="text" class="form-control" id="rollNo" name="rollNo" readonly value="<c:out value="${student.rollNo}" />">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Name</label>
					<input type="text" class="form-control" id="name" name="name" value="<c:out value="${student.name}" />">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Age</label>
					<input type="text" class="form-control" id="age" name="age" value="<c:out value="${student.age}" />">
				</div>
                 
                 <div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Department</label>
					<input type="text" class="form-control" id="department" name="department" value="<c:out value="${student.department}" />">
				</div>
                 
				<div>
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</form>
		</div>

	</div>
</body>

</html>