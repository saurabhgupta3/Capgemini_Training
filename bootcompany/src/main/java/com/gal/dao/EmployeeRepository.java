package com.gal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gal.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT e from Employee e where e.employeeid = :id")
	Employee getEmployeeById(@Param("id") int id);
	
	@Query("SELECT e from Employee e where e.fName = :name")
	Employee getEmployeeByName(@Param("name") String name);
	
}
