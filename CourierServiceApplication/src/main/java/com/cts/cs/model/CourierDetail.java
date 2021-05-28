package com.cts.cs.model;

public class CourierDetail {
	private String courierDeliveryType;
	private String weightSlab;
	private int frieghtRatePerGram;
	
	public CourierDetail() {
		// TODO Auto-generated constructor stub
	}

	public CourierDetail(String courierDeliveryType, String weightSlab, int frieghtRatePerGram) {
		super();
		this.courierDeliveryType = courierDeliveryType;
		this.weightSlab = weightSlab;
		this.frieghtRatePerGram = frieghtRatePerGram;
	}

	public String getCourierDeliveryType() {
		return courierDeliveryType;
	}

	public void setCourierDeliveryType(String courierDeliveryType) {
		this.courierDeliveryType = courierDeliveryType;
	}

	public String getWeightSlab() {
		return weightSlab;
	}

	public void setWeightSlab(String weightSlab) {
		this.weightSlab = weightSlab;
	}

	public int getFrieghtRatePerGram() {
		return frieghtRatePerGram;
	}

	public void setFrieghtRatePerGram(int frieghtRatePerGram) {
		this.frieghtRatePerGram = frieghtRatePerGram;
	}
	
	
}
