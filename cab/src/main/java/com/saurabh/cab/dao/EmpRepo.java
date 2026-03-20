package com.saurabh.cab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.cab.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
