package com.saurabh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
