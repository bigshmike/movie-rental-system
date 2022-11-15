<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie to Databse</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="processMovie" modelAttribute="movie" method="post"
			class="row g-3">
			<form:hidden path="id" />
			<h1>Add Movie to Database</h1>
			<div class="col-12">
				<label for="title" class="form-label">Title</label>
				<form:input path="title" type="text" class="form-control" id="title"
					placeholder="ex: Bridesmaids" />
			</div>
			<div class="col-12">
				<label for="movieInfo" class="form-label">Description</label>
				<form:textarea path="movieInfo" type="text" class="form-control"
					id="movieInfo"
					placeholder="ex: A movie about a group of women celebrating another woman's engagement but things go awfuly awry..." />
			</div>
			<div class="col-md-3">
				<label for="length" class="form-label">Length (minutes)</label>
				<form:input path="lengthInMin" type="number" class="form-control"
					id="length" placeholder="180" />
			</div>
			<div class="col-md-3">
				<label for="yearMade" class="form-label">Year Made</label>
				<form:input path="yearMade" type="number" class="form-control"
					id="yearMade" value="1900" />
			</div>
			<div class="col-md-3">
				<label for="releaseDate" class="form-label">Release Date</label>
				<form:input path="releaseDate" type="number" class="form-control"
					id="releaseDate" value="1900" />
			</div>
			<div class="col-md-3">
				<label for="numOfCopies" class="form-label"># of Copies</label>
				<form:input path="numOfCopies" type="number" class="form-control"
					id="numOfCopies" value="1" />
			</div>
			<div class="col-md-3">
				<label for="rating" class="form-label">Rating</label>
				<form:select path="rating" class="form-control" id="rating"
					name="rating">
					<form:options items="${ratings}" />
				</form:select>
			</div>
			<div class="col-md-9">
				<label for="genre" class="form-label">Genre</label>
				<div class="form-check">
					<form:checkboxes path="genre" name="genre" id="genre"
						items="${genres }" />
				</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Add Movie</button>
			</div>
		</form:form>
		<a href="<c:url value="/" />">Back to Main</a>
	</div>
</body>
</html>