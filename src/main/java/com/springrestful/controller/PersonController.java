package com.springrestful.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrestful.model.Person;
import com.springrestful.model.Result;
import com.springrestful.services.PersonService;

@RestController
@RequestMapping("/api")
@Api(value="PersonController", description="Operations pertaining to persons")
public class PersonController {
	
	private PersonService personService;
	 
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    
	@ApiOperation(value = "Add a person")
	@RequestMapping(value = "/addperson", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> addPerson(@RequestBody Person person) {
		Result result = new Result();
		personService.addPerson(person);
		result.setResultCode("1000");
		result.setResultDesc("Successful Create Person");
		return new ResponseEntity<Result>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Edit a person")
	@RequestMapping(value = "/editperson/{personid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> editPerson(@RequestBody Person person, @PathVariable("personid") int personId) {
		Result result = new Result();
		personService.editPerson(person, personId);
		result.setResultCode("1000");
		result.setResultDesc("Successful Edit Person");
		return new ResponseEntity<Result>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a person by id")
	@RequestMapping(value = "/deleteperson/{personid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> deletePerson(@PathVariable("personid") int personId) {
		Result result = new Result();
		personService.deletePerson(personId);
		result.setResultCode("1000");
		result.setResultDesc("Successful Delete Person");
		return new ResponseEntity<Result>(result, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "View a list of available persons", response = List.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value = "/listperson", method= RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Result> listPerson() {
		Result result = new Result();
		List<Person> returnList = personService.findAll();
		if(returnList.isEmpty()) {
			result.setResultCode("2000");
			result.setResultDesc("Record no found.");
			return new ResponseEntity<Result>(result, HttpStatus.NO_CONTENT);
		} else {
			result.setResultCode("1000");
			result.setResultDesc("Successful Select All Person");
			result.setListperson(returnList);
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Select a person by id")
	@RequestMapping(value = "/listpersonbyid/{personid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> listPersonById(@PathVariable("personid") int personId) {
		Result result = new Result();
		Person person = personService.find(personId);
		if(person == null) {
			result.setResultCode("2000");
			result.setResultDesc("Record no found.");
			return new ResponseEntity<Result>(result, HttpStatus.NO_CONTENT);
		} else {
			result.setResultCode("1000");
			result.setResultDesc("Successful Select All Person");
			result.setPerson(person);
			return new ResponseEntity<Result>(result, HttpStatus.OK);
		}
	}
}
