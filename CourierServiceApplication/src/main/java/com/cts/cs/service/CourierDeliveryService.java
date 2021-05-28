package com.cts.cs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.cs.model.CourierDetail;
import com.cts.cs.model.CourierBooking;

@Service
public class CourierDeliveryService {
	
	public double calculatePayableAmount(CourierBooking courierBooking) {
		double payableAmount=0.0;
		
		List<CourierDetail> courierAllDetails=buildCourierDetails();
		String deliveryArea=courierBooking.getCourierDeliveryArea();
		double weightIngrms=courierBooking.getPacketWeightInGrams();
		
		for(CourierDetail courierDetail:courierAllDetails) {
			if(deliveryArea.equals(courierDetail.getCourierDeliveryType())) {
				String slab=courierDetail.getWeightSlab();
				String []values=slab.split("-");
				
				String x[]=values[0].split("grm");
				int lowerBound=Integer.parseInt(x[0]);
		        
		        String y[]=values[1].split("grm");
		        int upperBound=Integer.parseInt(y[0]);
		        
				System.out.println(lowerBound+" "+upperBound);
				if(weightIngrms>=lowerBound && weightIngrms<=upperBound) {
					
					payableAmount=weightIngrms*courierDetail.getFrieghtRatePerGram();
				}
			}
		}
		return payableAmount;
	}
	
	//convert localdatetime into string for courier deliveryDate
	public String  getCourierDateOfDelivery(String courierDeliveryArea) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String deliveryDate="";
		if(courierDeliveryArea.equals("Local")) {
			deliveryDate=LocalDateTime.now().plusDays(5).format(formatter);
		}else {
			deliveryDate=LocalDateTime.now().plusDays(10).format(formatter);
		}
		return deliveryDate;
		//return "";
	}
	
	//convert localdatetime into string for courier shipment date
	public String getCourierDateOfShipment() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String shipmentDate=LocalDateTime.now().format(formatter);
		return shipmentDate;
		//return "";
	}
	
	public String getCourierTrackingNumber(CourierBooking courierBooking) {
		int id=CourierBooking.getCourierTrackingNumber();
		String customerName=courierBooking.getCustomerName();
		String trackingNumber=customerName.substring(0,3).toUpperCase()+id;
		return trackingNumber;
		//return "";
	}
	
	//Courier charges as per slab and delivery area
	private List<CourierDetail> buildCourierDetails() {
		List<CourierDetail> courierDetailsList=new ArrayList<CourierDetail>();
		
		//local delivery area
		CourierDetail courierDetail1=new CourierDetail();
		courierDetail1.setCourierDeliveryType("Local");
		courierDetail1.setWeightSlab("1grm-50grm");
		courierDetail1.setFrieghtRatePerGram(2);
		courierDetailsList.add(courierDetail1);
		
		CourierDetail courierDetail2=new CourierDetail();
		courierDetail2.setCourierDeliveryType("Local");
		courierDetail2.setWeightSlab("51grm-100grm");
		courierDetail2.setFrieghtRatePerGram(3);
		courierDetailsList.add(courierDetail2);
		
		CourierDetail courierDetail3=new CourierDetail();
		courierDetail3.setCourierDeliveryType("Local");
		courierDetail3.setWeightSlab("101grm-500grm");
		courierDetail3.setFrieghtRatePerGram(5);
		courierDetailsList.add(courierDetail3);
		
		CourierDetail courierDetail4=new CourierDetail();
		courierDetail4.setCourierDeliveryType("Local");
		courierDetail4.setWeightSlab("501grm-2000grm");
		courierDetail4.setFrieghtRatePerGram(8);
		courierDetailsList.add(courierDetail4);
		
		//national delivery area
		CourierDetail courierDetail5=new CourierDetail();
		courierDetail5.setCourierDeliveryType("National");
		courierDetail5.setWeightSlab("1grm-50grm");
		courierDetail5.setFrieghtRatePerGram(5);
		courierDetailsList.add(courierDetail5);
		
		CourierDetail courierDetail6=new CourierDetail();
		courierDetail6.setCourierDeliveryType("National");
		courierDetail6.setWeightSlab("51grm-100grm");
		courierDetail6.setFrieghtRatePerGram(8);
		courierDetailsList.add(courierDetail6);
		
		CourierDetail courierDetail7=new CourierDetail();
		courierDetail7.setCourierDeliveryType("National");
		courierDetail7.setWeightSlab("101grm-500grm");
		courierDetail7.setFrieghtRatePerGram(10);
		courierDetailsList.add(courierDetail7);
		
		CourierDetail courierDetail8=new CourierDetail();
		courierDetail8.setCourierDeliveryType("National");
		courierDetail8.setWeightSlab("501grm-2000grm");
		courierDetail8.setFrieghtRatePerGram(12);
		courierDetailsList.add(courierDetail8);
		
		return courierDetailsList;
	}
}
