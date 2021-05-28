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
<body style='margin-left: 30px;'>
	<div style='background: lightgray; width: 450px;'>
		<h2 id="heading1">Library management System</h2>
		<h3 id="heading2">Book search page</h3>
		 <p id="error" style="color:red; font-size: large; font-weight: bold;">${error}</p>
		
		<form method="POST">

			Search Option: 
			<input type='radio' id = "subject" name="option" value='subject'> On Subject 
			<input type='radio' id = "title"name='option' value='title'> On Title
			 <br> <br> 
			 Title / Subject 
			 <input type='text' id = "text" name='text'/> <br> 
			 <input type='submit' name = "submit" value='Submit'> <br> <br>

		</form>
	</div>
</body>

</html>