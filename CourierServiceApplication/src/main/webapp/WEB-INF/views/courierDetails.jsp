<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<h2 id="courierDetails">Courier Details</h2>
	<table>
	<sf:form action="getCourierDeliveryDate" modelAttribute="courierBooking" method="POST" name="form">
		<tr>
			<td>Customer Name</td>
			<td>
			<sf:input path="customerName" id="customerName"
						name="customerName" value="${courierCharges.customerName}" readonly="true"/> </td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><sf:input path="mobileNumber" id="mobileNumber"
						name="mobileNumber" value="${courierCharges.mobileNumber}" readonly="true"/></td>
		</tr>
		<tr>
			<td>Delivery Area</td>
			<td><sf:input path="courierDeliveryArea" id="courierDeliveryArea"
						name="courierDeliveryArea" value="${courierCharges.courierDeliveryArea}" readonly="true"/>    </td>
		</tr>
		<tr>
			<td>Payable Amount</td>
			<td><sf:input path="payableAmount" id="payableAmount"
						name="payableAmount" value="${courierCharges.payableAmount}" readonly="true"/></td>
		</tr>
		<tr>
			<td><input type="submit" id="submit" name="submit"
					value="ShipCourier"></td>
		</tr>
		</sf:form>
	</table>
	
	
</body>
</html>