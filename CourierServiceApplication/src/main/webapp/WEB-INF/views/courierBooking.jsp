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
	<h1 id="heading">Appex Courier Services</h1>
	
	<table>
	<caption style="font-weight: bolder;">Courier Booking</caption>
	<sf:form action="getCourierDeliveryCharges" modelAttribute="courierBooking" method="POST" name="form">
			<tr>
				<td>Customer Name:</td>
				<td><sf:input path="customerName" id="customerName"
						name="customerName" /> <sf:errors style="color:red" path="customerName"></sf:errors></td>
			</tr>
				<tr>
				<td>Customer City:</td>
				<td><sf:select path="customerCity" items="${cities}"
						id="customerCity" name="customerCity">
						<sf:errors path="customerCity"></sf:errors>
					</sf:select><br></td>
				</tr>
				<tr>
				<td>Mobile Number:</td>
				<td><sf:input path="mobileNumber" id="mobileNumber"
						name="mobileNumber" /> <sf:errors style="color:red" path="mobileNumber"></sf:errors></td>
				</tr>
				
				<tr>
				<td>Courier Delivery Area:</td>
				<td><sf:radiobutton path="courierDeliveryArea" id="courierDeliveryArea1"
						name="courierDeliveryArea"  value="Local"/>Local
						<sf:radiobutton path="courierDeliveryArea" id="courierDeliveryArea2"
						name="courierDeliveryArea"  value="National"/>National
						 <sf:errors style="color:red" path="courierDeliveryArea"></sf:errors></td>
			</tr>
			<tr>
				<td>Packet Weight In Grams</td>
				<td><sf:input path="packetWeightInGrams" id="packetWeightInGrams"
						name="packetWeightInGrams" /> <sf:errors style="color:red" path="packetWeightInGrams"></sf:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" id="submit" name="submit"
					value="PayableAmount"></td>
				<td><input type="reset" id="Clear" name="Clear" value="Clear"></td>
			</tr>
		</sf:form>
	</table>
</body>
</html>