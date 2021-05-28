package com.cts.cs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.cs.model.CourierBooking;
import com.cts.cs.service.CourierDeliveryService;


@Controller
public class CourierDeliveryServiceController {
	
	@Autowired
	private CourierDeliveryService service;
	@Autowired
	private Validator validator;
	
	@RequestMapping(value = "/showCourierBookingForm",method=RequestMethod.GET)
	public String showCourierBookingForm(@ModelAttribute("courierBooking") CourierBooking courierBooking) {
		return "courierBooking";
		//return "";
	}
	
	@RequestMapping(value = "/getCourierDeliveryCharges", method = RequestMethod.POST)
	public String getCourierDeliveryCharges(@ModelAttribute("courierBooking") CourierBooking courierBooking, ModelMap map,
			BindingResult result) {
		validator.validate(courierBooking, result);
		if (result.hasErrors()) {
			return "courierBooking";
		}else 
		if(courierBooking.getPacketWeightInGrams()>2000){
			return "weightCheck";
		}else {
			double payableAmount=service.calculatePayableAmount(courierBooking);
			courierBooking.setPayableAmount(payableAmount);
			map.addAttribute("courierCharges", courierBooking);
			
			return "courierDetails";
		}
		//return "";
	}
	@RequestMapping(value = "/getCourierDeliveryDate", method = RequestMethod.POST)
	public String getCourierDeliveryDate(@ModelAttribute("courierBooking")  CourierBooking courierBooking, ModelMap map,
			BindingResult result) {
		if (result.hasErrors()) {
			return "courierBooking";
		}else {
			String shipmentDate=service.getCourierDateOfShipment();
			String deliveryDate=service.getCourierDateOfDelivery(courierBooking.getCourierDeliveryArea());
			String courierTrackingNumber=service.getCourierTrackingNumber(courierBooking);
			
			
			String shipment="CourierTracking Number:"+courierTrackingNumber+"<br><br>Courier shipped on:"+shipmentDate+"<br><br>"+"Expected delivery date:"+deliveryDate;
					
				map.addAttribute("message", shipment);

			return "courierShipment";
		}	
		//return "";
	}
	
	
	
	@ModelAttribute("cities")
	public List<String> populateCities() {
		List<String> cities = new ArrayList<String>();
		 
		  cities.add("Chennai"); 
		  cities.add("Mumbai");
		  cities.add("Delhi"); 
		  cities.add("Bangalore"); 
		  cities.add("Pune");
		  cities.add("Kolkatta");
		 
		
		return cities;
	}
}
