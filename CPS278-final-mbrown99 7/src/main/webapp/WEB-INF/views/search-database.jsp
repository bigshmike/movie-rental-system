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
		<form:form action="processSearchRequest" modelAttribute="searchRequest" method="post"
			class="row g-3">
			<h1>Search Database</h1>
			<div class="col-12">
			<form:radiobutton class="form-check-input" path="searchType" value="title" name="title" id="title" checked="checked"/> Title
			<form:radiobutton class="form-check-input" path="searchType" value="movie_info" name="movie_info" id="movie_info"/> Description <br>
				<form:input path="inputText" name="inputText" type="text" class="form-control" id="search"
					placeholder="Enter a keyword..." />
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form:form>
		<a href="<c:url value="/" />">Back to Main</a>
	</div>
</body>
</html>