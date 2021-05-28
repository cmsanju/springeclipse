package com.cts.cs.model;

import javax.validation.constraints.AssertTrue.List;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CourierBooking {

	private static int courierTrackingNumber = 1000;

	// Use validation annotations as per the requirement
	// add constructor and increment courierTrackingNumber by 1

	@NotBlank(message = "Customer name is required")
	private String customerName;
	@NotNull(message = "Customer city is required")
	private String customerCity;
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "[0-9]{10}", message = "Mobile number should be 10 digits")
	private String mobileNumber;
	@NotBlank(message = "Courier delivery area is required")
	private String courierDeliveryArea;
	@Min(value = 1, message = "Packet weight must be more then 0")
	// @Max(value = 2000, message = "Packet weight must be between 1grm to 2kg")
	private double packetWeightInGrams;
	private LocalDateTime dateOfShipment;
	private LocalDateTime dateOfDelivery;
	private double payableAmount;

	public CourierBooking() {
		courierTrackingNumber = courierTrackingNumber + 1;
	}

	public static int getCourierTrackingNumber() {
		return courierTrackingNumber;
	}

	public static void setCourierTrackingNumber(int courierTrackingNumber) {
		CourierBooking.courierTrackingNumber = courierTrackingNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCourierDeliveryArea() {
		return courierDeliveryArea;
	}

	public void setCourierDeliveryArea(String courierDeliveryArea) {
		this.courierDeliveryArea = courierDeliveryArea;
	}

	public double getPacketWeightInGrams() {
		return packetWeightInGrams;
	}

	public void setPacketWeightInGrams(double packetWeightInGrams) {
		this.packetWeightInGrams = packetWeightInGrams;
	}

	public LocalDateTime getDateOfShipment() {
		return dateOfShipment;
	}

	public void setDateOfShipment(LocalDateTime dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	public LocalDateTime getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(LocalDateTime dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

}
