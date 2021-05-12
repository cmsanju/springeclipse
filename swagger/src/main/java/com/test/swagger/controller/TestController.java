package com.test.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
@Api(value = "Endpoints for Retrieving of Test String List.", tags = {"List String"})
public class TestController {

	@ApiOperation(value = "API to GET Test list String", notes = "Get all string list", tags = { "TestString" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List retrieve success", response=List.class )
	})
	@GetMapping
	public List<String> getTest(){
		List<String> strings = new ArrayList<>();
		return strings;
	}
}
