package com.springrestful.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrestful.model.Result;

@RestController
@RequestMapping("/api")
@Api(value="TestController", description="Operations pertaining to testing")
public class TestController {

	@ApiOperation(value = "Received Greeting",response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	@RequestMapping(value = "/helloworld/", method = RequestMethod.GET)
	public ResponseEntity<Result> helloworld() {
		Result result = new Result();
		result.setResultCode("1000");
		result.setResultDesc("Hello SpringRestful API");
		return new ResponseEntity<Result>(result, HttpStatus.OK);
	}
}
