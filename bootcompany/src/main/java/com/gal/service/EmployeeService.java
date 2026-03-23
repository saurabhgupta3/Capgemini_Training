package com.gal.service;

import java.util.List;

import com.gal.model.Employee;


public interface EmployeeService {
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee emp);
	Employee getEmployeeByName(String name);
	Employee updateEmployee(Employee emp);
}
