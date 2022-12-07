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
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Login</th>
				</tr>
			</thead>
			<c:forEach var="eachCustomer" items="${customers }">
				<c:url var="checkoutHistoryUrl" value="/rentalHistory">
					<c:param name="customerId" value="${eachCustomer.id}"></c:param>
				</c:url>
				<tbody>
					<tr>
						<td><a href="${checkoutHistoryUrl }">${eachCustomer.firstName }</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<a href=${pageContext.request.contextPath}/addMovie><button class="btn btn-primary" type="button">Add Movie to Database</button></a> 
		<a href=${pageContext.request.contextPath}/searchMoviesGuest><button class=" btn btn-primary" type="button">Browse
			Database as Guest</button></a>
	</div>
</body>
</html>