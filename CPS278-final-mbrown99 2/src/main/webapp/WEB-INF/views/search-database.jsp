<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="searchMovies" modelAttribute="movieInfo" method="post"
			class="row g-3">
			<form:hidden path="id" />
			<h1>Search Database</h1>
			<div class="col-12">
				<label for="movieInfo" class="form-label">Search by Description: </label>
				<form:input path="movieInfo" type="text" class="form-control" id="movieInfo"
					placeholder="desc" />
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Add Movie</button>
			</div>
		</form:form>
		<a href="<c:url value="/" />">Back to Main</a>
	</div>
</body>
</html>