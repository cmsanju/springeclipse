package com.org.controller;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.RecordNotFoundException;
import com.org.model.Schedule;
import com.org.service.AirportService;
import com.org.service.ScheduleService;


@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	AirportService airportService;
	
	@DeleteMapping("/deleteschedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeAirport(@PathVariable("id") BigInteger id) {
		scheduleService.removeSchedule(id);
	}
	
	@GetMapping("/viewschedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Schedule viewAirport(@PathVariable("id") BigInteger id) {
		return scheduleService.viewSchedule(id);
	}
	
	@GetMapping("/allschedules")
	public Iterable<Schedule> viewAllAirport() {
		return scheduleService.viewAllSchedules();
	}
	
	@PostMapping("/addschedule")
	public ResponseEntity<Schedule> AddSchedule(@RequestBody Schedule schedule) {
		try {
			return new ResponseEntity<Schedule>(scheduleService.addSchedule(schedule),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Error adding Schedule" + e, HttpStatus.BAD_REQUEST);
		}
	}
}
