<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book search Result</title>
</head>
<body>
	<h2>${book.quantity} copies of ${book.title} written by
		${book.author} are available</h2>
	<br>
	<a id = "back" href="/"> Back to search page</a><br>
	<a id = "fback" href="feedback">Click to provide your feedback</a>
</body>
</html> 