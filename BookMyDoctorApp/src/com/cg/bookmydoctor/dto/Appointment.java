package com.cg.bookmydoctor.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
	private int appointmentId;
	private Doctor doctor;
	private Patient patient;
	private LocalDateTime appointmentDate;
	private String appointmentStatus;//approved ,cancelled,completed	
	
}
