<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject Search Result</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Quantity</th>
		</tr>
		<c:forEach var="book" items="${bookList}">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a id="back" href="/"> Back to search page</a><br>
	<a id ="fback" href="feedback">Click to provide your feedback</a>
</body>
</html>