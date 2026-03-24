package com.saurabh.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.model.Issue;
import com.saurabh.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	
	//first question
	@GetMapping("/all/{empId}")
	public List<Issue> getAll(@PathVariable int empId) {
		log.debug("request for getting all issued raised by an employee that are still unresolved for " + empId);
		return service.getAll(empId);
	}
	
	//second question
	@GetMapping("/issue/current")
    public List<Issue> getAllCurrentMonthIssues() {
		log.debug("request for accessing all issues raised by any employee this month");
        return service.getAllCurrentMonthIssues();
    }
	//third question
	@GetMapping("/employees/issues/current")
	public List<String> getEmployeeNames() {
		log.debug("requst for accessing employess names who raised any issue this month");
	    return service.getEmployeeNames();
	}
	@PostMapping(value = "/issue", consumes = "application/json", produces = "application/json")
	public Issue addIssue(@RequestBody Issue issue) {
		log.debug("request for adding issue " + issue);
		return service.addIssue(issue);
	}
}
