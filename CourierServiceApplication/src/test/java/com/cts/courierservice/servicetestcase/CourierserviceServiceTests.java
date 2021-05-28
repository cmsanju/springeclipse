package com.cts.courierservice.servicetestcase;

import org.testng.annotations.Test;

import com.cts.cs.model.CourierBooking;
import com.cts.cs.service.CourierDeliveryService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterClass;

public class CourierserviceServiceTests {
	
	CourierBooking courierBooking=new CourierBooking();
	CourierDeliveryService service=new CourierDeliveryService();
	
  @BeforeMethod
  public void beforeMethod() {
	  	courierBooking=new CourierBooking();
	  	courierBooking.setCustomerName("Smith");
		courierBooking.setCustomerCity("Chennai");
		courierBooking.setMobileNumber("8345678901");
		courierBooking.setCourierDeliveryArea("Local");
		courierBooking.setPacketWeightInGrams(20);		
  }

  @AfterMethod
  public void afterMethod() {
	  courierBooking=null;
  }

  @Test
  public void testcalculatePayableAmount() throws Exception {
		double payableAmount=service.calculatePayableAmount(courierBooking);
		assertEquals(payableAmount, 40.0, "Calculation of payable amount failed");
	  }
  
  @Test
  public void testgetCourierDateOfDelivery() throws Exception {
		String actualDeliveryDate=service.getCourierDateOfDelivery(courierBooking.getCourierDeliveryArea());
		String expectedDeliveryDate=LocalDateTime.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		assertEquals(actualDeliveryDate,expectedDeliveryDate,"Courier date of delivery failed");
		
		//for national
		String actualDeliveryDate1=service.getCourierDateOfDelivery("National");
		String expectedDeliveryDate1=LocalDateTime.now().plusDays(10).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		assertEquals(actualDeliveryDate1,expectedDeliveryDate1,"Courier date of delivery failed");
	  }
  
  @Test
  public void testgetCourierDateOfShipment() throws Exception {
	  	String actualDateOfShipment=service.getCourierDateOfShipment();
		String expectedDateOfShipment=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		
		assertEquals(actualDateOfShipment, expectedDateOfShipment,"Courier date of shipment failed");
		
	  }
  
  @Test
  public void testgetCourierTrackingNumber() throws Exception {
		String actualTrackingNum=service.getCourierTrackingNumber(courierBooking);
		String expectedTrackingNum=courierBooking.getCustomerName().substring(0,3).toUpperCase()+CourierBooking.getCourierTrackingNumber();
		assertEquals(actualTrackingNum,expectedTrackingNum, "Courier tracking number failed");
	  }
  
  @Test
  public void testTrackingNumberIncremented() throws Exception{
	  assertTrue(CourierBooking.getCourierTrackingNumber()>1000, "Tracking numer not incremented");
  }
  
}
