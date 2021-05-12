package com.test.swagger.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@GetMapping
	public List<Employee> getEmployee(){
		List<Employee> employees = new ArrayList<>();
		return employees;
	}

	@PostMapping
	public Boolean save(@RequestBody Employee employee) {
		//@TODO save employee
		return true;
	}

	@PutMapping(value = "{id}")
	public Boolean update(@PathVariable Integer id,@RequestBody Employee employee) {
		//@TODO update employee
		return true;
	}

	@DeleteMapping(value = "{id}")
	public Boolean delete(@PathVariable Integer id){
		//@TODO delete employee
		return true;
	}

}
