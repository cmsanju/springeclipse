package com.cg.bookmydoctor.service;

import java.util.List;

import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;

public interface IDoctorService {

	public Doctor addDoctor(Doctor bean);
	public Doctor updateDoctorProfile(Doctor bean);
	public boolean addAvailability(AvailabilityDates bean);
	public boolean updateAvailability(AvailabilityDates bean);
	public Doctor getDoctor(Doctor doc);
	public Doctor removeDoctor(Doctor doc);
	public List<Doctor> getDoctorList();
	public List<Doctor> getDoctorList(String speciality);
}
