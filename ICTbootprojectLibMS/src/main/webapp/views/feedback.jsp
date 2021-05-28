<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Search Page</title>
</head>
<body style='margin-left: 30px'>
	
		<h2 id="heading3">Library management System</h2>
		<h3 id="heading4">Please provide your feedback</h3>
		<form method="POST" action="/feedback">

			Rate your experience: 
			 
			<input type='radio'  name="rating" value='1'> Poor 
			<input type='radio'  name="rating" value='2'> Average
			<input type='radio'  name="rating" value='3'> Good
			<input type='radio' name="rating" value='4'> Very Good
			<input type='radio' name="rating" value='5' checked> Excellent
			 <br> <br> 
			 Leave Your Comment Here:<br>
			 <textarea  id="fb" name ='comment' rows="5" cols='20'></textarea> <br> <br>
			 <input type='submit' value='Submit'> <br> <br>

		</form>
	
</body>

</html>