package com.cts.courierservice.controllertestcase;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.cs.controller.CourierDeliveryServiceController;
import com.cts.cs.model.CourierBooking;
import com.cts.cs.service.CourierDeliveryService;


@SpringBootTest(classes = { CourierDeliveryServiceController.class, CourierDeliveryService.class })
@AutoConfigureMockMvc
@ComponentScan(basePackages= {"com.*"})
class CourierserviceControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CourierDeliveryService courierDeliveryService;
	
	@Test 
	  public void testCourierBookingForm() throws Exception {
		  mockMvc.perform(get("/showCourierBookingForm"))
		 .andExpect(status().isOk()) 
		 .andExpect(view().name("courierBooking"));		  
	  }
	
	@Test
	public void testgetCourierDeliveryChargesWithoutCourier() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/getCourierDeliveryCharges");		
				mockMvc.perform(request)
				.andExpect(status().isOk())				
					.andExpect(view().name("courierBooking"));				
	}
	
	@Test
	public void testgetCourierDeliveryChargesWithCourier() {
		try {
			CourierBooking courierBooking = new CourierBooking();
			courierBooking.setCustomerName("John");
			courierBooking.setCustomerCity("Mumbai");
			courierBooking.setMobileNumber("1234567890");
			courierBooking.setCourierDeliveryArea("National");
			courierBooking.setPacketWeightInGrams(20);
		
				RequestBuilder request = MockMvcRequestBuilders.post("/getCourierDeliveryCharges").flashAttr("courierBooking", courierBooking);
				mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(view().name("courierDetails"));
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testgetCourierDeliveryChargesWithCourierWrongDetails() {
		try {
			CourierBooking courierBooking = new CourierBooking();
			courierBooking.setCustomerName("John");
			courierBooking.setCustomerCity("Mumbai");
			courierBooking.setMobileNumber("1234567890");
			courierBooking.setCourierDeliveryArea("National");
			courierBooking.setPacketWeightInGrams(25000);
			
				RequestBuilder request = MockMvcRequestBuilders.post("/getCourierDeliveryCharges").flashAttr("courierBooking", courierBooking);
				mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(view().name("weightCheck"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testcourierShipmentDetails() {		
		try {
			CourierBooking courierBooking = new CourierBooking();
			courierBooking.setCustomerName("John");
			courierBooking.setMobileNumber("1234567890");
			courierBooking.setCourierDeliveryArea("National");
			courierBooking.setPayableAmount(55.0);
		
				RequestBuilder request = MockMvcRequestBuilders.post("/getCourierDeliveryDate").flashAttr("courierBooking", courierBooking);
				mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(view().name("courierShipment"));
			
		} catch (Exception e) {
			fail(e.getMessage());
		}

		
		
		
	}
}
