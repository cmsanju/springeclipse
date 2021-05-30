package com.org.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.dao.ScheduleDao;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	ScheduleDao dao;
	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return dao.save(schedule);
	}
	
	@Override
	public Iterable<Schedule> viewAllSchedules() {
		return dao.findAll();
	}
	
	@Override
	public Schedule viewSchedule(BigInteger scheduleId){
		Optional<Schedule> findById = dao.findById(scheduleId);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("No schedule exists");
	   }
	
	@Override
	public String removeSchedule(BigInteger scheduleid){
		Optional<Schedule> findById = dao.findById(scheduleid);
		if (findById.isPresent()) {
			dao.deleteById(scheduleid);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Schedule record not found");

	}
	
	@Override
	public Schedule modifySchedule(Schedule schedule) {
		Schedule updateSchedule = dao.findById(schedule.getScheduleId()).get();
		updateSchedule.setArrDateTime(schedule.getArrDateTime());
		updateSchedule.setDeptDateTime(schedule.getDeptDateTime());
		dao.save(updateSchedule);
		return schedule;
	}
}

