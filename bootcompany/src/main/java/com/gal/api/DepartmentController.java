package com.gal.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gal.model.Department;
import com.gal.service.DepartmentService;

@RestController
public class DepartmentController {
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	
	
	@Autowired
	DepartmentService service;
	
//	@RequestMapping("/department/{id}")
//	public Department getDepartmentById2(@PathVariable("depid") int depid) {
//		Department d = depService.find(depid);
//		return d;
//	}
//	@GetMapping("/department/{id}")
//	public Department getDepartmentById(@PathVariable int id) {
//		return service.getDepartmentById(id);
//	}
	@GetMapping(
		    value = "/department/{id}",
		    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
		)
	public ResponseEntity getDepartmentById(@PathVariable int id) {
		log.debug("request for departmentid :" + id);
		Department dep = service.getDepartmentById(id);
		if(dep == null) {
//			return ResponseEntity.notFound().build();
			DepartmentNotFoundException obj =  new DepartmentNotFoundException("Department id " + id + " does not exist");
			throw obj;
		}
		return ResponseEntity.ok(dep); 
	}
	@PostMapping(value = "/department", consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Department addDepartment(@RequestBody Department dep) {
	    log.debug("request for adding department " + dep);
	    return service.addDepartment(dep);
	}
	@PutMapping("/department")
	
	public Department updateDepartment(@RequestBody Department dep) {
		log.debug("request for adding department " + dep);
		return service.updateDepartment(dep);
	}
	
}
