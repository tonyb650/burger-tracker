<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Burger Tracker</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Burger Tracker</h1>
		<table class="table border">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${allBurgers}">
					<tr>
						<td><c:out value="${ burger.burgerName }"/></td>
						<td><c:out value="${ burger.restaurantName }"/></td>
						<td><c:out value="${ burger.rating }"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<h1>Burger Tracker</h1>
			<form:form action="/burgers" method="post" modelAttribute="burger">
				<div><form:errors path="burgerName" class="form-label text-danger"/></div>
				<div><form:errors path="restaurantName" class="form-label text-danger"/></div>
				<div><form:errors path="rating" class="form-label text-danger"/></div>
				<div><form:errors path="burgerNotes" class="form-label text-danger"/></div>
				<form:label path="burgerName" class="form-label" for="burgerName">Burger name</form:label>
				<form:input path="burgerName" class="form-control" name="burgerName" id="burgerName" type="text" />
				<form:label path="restaurantName" class="form-label" for="restaurantName">Restaurant name</form:label>
				<form:input path="restaurantName" class="form-control" name="restaurantName" id="restaurantName" type="text" />
				<form:label path="rating" class="form-label" for="rating">Rating</form:label>
				<form:input path="rating" class="form-control" name="rating" id="rating" type="number" min="1" max="5"/>
				<form:label path="burgerNotes" class="form-label" for="burgerNotes">Notes</form:label>
				<form:textarea path="burgerNotes" class="form-control" name="burgerNotes" id="burgerNotes" rows="4"></form:textarea>
				<input type="submit" class="btn btn-secondary" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>