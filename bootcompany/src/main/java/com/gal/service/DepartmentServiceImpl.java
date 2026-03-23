package com.gal.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.api.DepartmentController;
import com.gal.dao.DepartmentRepository;
import com.gal.model.Department;

@Service 
public class DepartmentServiceImpl implements DepartmentService {
	
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	DepartmentRepository repo;
	


	public Department getDepartmentById(int id) {
		return repo.getDepartmentById(id);
	}
	
	public Department addDepartment(Department dep) {
		return repo.save(dep);
	}
	public Department updateDepartment(Department dep) {
		Optional<Department> existing = repo.findById(dep.getDepartmentid());
		if(existing.isEmpty()) {
			log.error("this department not exist");
			throw new RuntimeException("Department  not found");
		}
		return repo.save(dep);
	}
	
}
