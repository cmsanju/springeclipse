<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		font-family: italian;
		color: red;
	}
</style>
</head>
<body>
<%-- <form action="customer" method = "post"> --%>
<!-- 	<h1>Customer form</h1> -->
	
<!-- 	Enter id : <input type = "text" name = "id" required="required"><br><br> -->
<!-- 	Enter Name : <input type = "text" name = "name"><br><br> -->
<!-- 	Enter City : <input type = "text" name = "city"><br><br> -->
	
<!-- 			<input type = "submit" value = "send"> -->
<%-- 	</form> --%>

<form:form action="customer" method  = "post" modelAttribute="info">

	Enter ID <form:input path="id"/>
		<form:errors path="id" cssClass="error"></form:errors><br>
	Enter Name <form:input path="name"/><br>
	    <form:errors path="name" cssClass="error"></form:errors><br>
	Enter City <form:input path="city"/><br>
		<form:errors path = "city" cssClass="error"></form:errors><br>
		
	<input type = "submit" value = "send">
</form:form>

</body>
</html>