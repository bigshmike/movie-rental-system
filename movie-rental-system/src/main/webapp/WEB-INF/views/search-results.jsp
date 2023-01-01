<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Rental System - Search Results</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Movie Database</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Length</th>
					<th scope="col">Year Made</th>
					<th scope="col">Release Date</th>
					<th scope="col"># of Copies</th>
					<th scope="col"># of Available Copies</th>
					<th scope="col">Rating</th>
					<th scope="col">Genre</th>
					<th scope="col" />
				</tr>
			</thead>
			<c:forEach var="eachMovie" items="${queriedMovies}">
				<tbody>
					<tr>
						<td>${eachMovie.title }</td>
						<td>${eachMovie.movieInfo }</td>
						<td>${eachMovie.lengthInMin }</td>
						<td>${eachMovie.yearMade }</td>
						<td>${eachMovie.releaseDate }</td>
						<td>${eachMovie.numOfCopies }</td>
						<td>${eachMovie.numOfAvailableCopies }</td>
						<td>${eachMovie.rating }</td>
						<td>${eachMovie.genre }</td>
						<td>
     							<c:if test="${eachMovie.numOfAvailableCopies > 0}">
									<form action="rentMovie" method="post">
									<input type="hidden" name="customerId" value="${customerId }" />
										<input type="hidden" name="movieId" value="${eachMovie.id }" />
										<input type="submit" value="Rent Movie"
											class="btn btn-primary">
									</form>
								</c:if>
								</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<a href="<c:url value="/" />">Back to Main</a>
	</div>
</body>
</html>