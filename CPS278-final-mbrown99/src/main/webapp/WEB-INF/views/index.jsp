<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Rental System</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Movie Ordering System</h1>
		<form:form action="rentalHistory"
			class="row row-cols-lg-auto g-3 align-items-center" method="post">
			<div class="col-6">
				<select class="form-select" id="customerLogin">
					<option>Login as...</option>
					<c:forEach var="eachCustomer" items="${customers}">
						<option>${eachCustomer.firstName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-6">
				<button type="submit" class="btn btn-primary">Go</button>
			</div>
		</form:form>
		<a href=${pageContext.request.contextPath}/addMovie>Add Movie to
			Database</a> | <a href=${pageContext.request.contextPath}/searchMovies>Browse
			Database as Guest</a>
	</div>
</body>
</html>