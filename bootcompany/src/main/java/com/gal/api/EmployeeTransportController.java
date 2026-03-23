package com.gal.api;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.dao.EmployeeRepository;
import com.gal.model.Employee;
import com.gal.model.EmployeeTransportDTO;
import com.gal.service.EmployeeService;

@RestController
public class EmployeeTransportController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeTransportController.class);
	
	@Autowired
	EmployeeService service;
	@Autowired
	EmployeeRepository repo;
	
	@RequestMapping("/employee")
	public List<EmployeeTransportDTO> getAll() {
		return repo.findAll().stream().map(emp -> new EmployeeTransportDTO(emp)).collect(Collectors.toList());
	}
	
	@GetMapping("/employee/id/{id}")
	Employee getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	@PostMapping("/employee")
	Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	@GetMapping("/employee/name/{name}")
	Employee getEmployeeByName(@PathVariable String name) {
		return service.getEmployeeByName(name);
	}
	@PutMapping("/employee")
	Employee updateEmployee(@RequestBody Employee emp) {
		log.debug("request for adding employee" + emp);
		return service.updateEmployee(emp);
	}
}
