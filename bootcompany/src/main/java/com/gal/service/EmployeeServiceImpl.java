package com.gal.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.dao.EmployeeRepository;
import com.gal.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeRepository repo;
	public Employee getEmployeeById(int id) {
		return repo.getEmployeeById(id);
	}
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}
	public Employee getEmployeeByName(String name) {
		return repo.getEmployeeByName(name);
	}
	public Employee updateEmployee(Employee  emp) {
		Optional<Employee> existing = repo.findById(emp.getEmployeeid());
		if(existing.isEmpty()) {
			log.error("this department not exist");
			throw new RuntimeException("Department  not found");
		}
		return repo.save(emp);
	}
}
