package com.org.model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ScheduledFlight {

	@Id
	@Column(name = "schedule_flight_id")
	private BigInteger scheduleFlightId;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	private Flight flight;

	@Column(name = "available_seats")
	@NotNull
	private Integer availableSeats;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	private Schedule schedule;

	public ScheduledFlight() {

	}
	
	public ScheduledFlight(BigInteger scheduleFlightId, com.org.model.Flight flight, Integer availableSeats,
			Schedule schedule) {
		this.scheduleFlightId = scheduleFlightId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	/*
	 * Getter and setter for ID
	 */
	public BigInteger getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(BigInteger scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	/*
	 * Getter and setter for Available seats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	/*
	 * Getter and setter for Flight object
	 */
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/*
	 * Getter and setter for Schedule object
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	
}
