<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Rental System - Order History for ${customerName }</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Rental History for ${customerName }</h1>
		<table class="table">
			<tr>
				<th scope="col">Rental ID</th>
				<th scope="col">Movie</th>
				<th scope="col">Checkout Date</th>
				<th scope="col">Returned Date</th>
				<th scope="col">Return</th>
			</tr>
			<c:forEach var="eachRental" items="${rentals}">
				<tr>
					<td>${eachRental.id}</td>
					<td>${eachRental.movie }</td>
					<td>${eachRental.checkoutDate }</td>
					<td>${eachRental.returnedDate }</td>
					<td><c:if test="${empty eachRental.returnedDate}">
							<form action="returnMovie" method="post">
								<input type="hidden" name="rentalId" value="${eachRental.id }" />
								<input type="submit" value="Return Movie"
									class="btn btn-primary">
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<form action="searchDatabase" method="get">
			<input type="hidden" name="customerId" value="${customerId }" /> 
			<input type="submit" value="Search Database" class="btn btn-primary">
		</form>
		<a href="<c:url value="/" />">Back to Main</a>
	</div>
</body>
</html>