package com.gal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gal.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	
	@Query("SELECT d from Department d where d.departmentid = :id")
	Department getDepartmentById(@Param("id") int id);
//	@Query("from Department d where d.depname=:depname")
//	//for sql -> @Query(value="select * from department d where d.department_name=:depname", nativeQuery=true)
//	//HQL JPQL : SQL Query with objects in mind
//	//select * from department
//	//select d from Department d
//	//select * from department where department_name = :name
//	//select d from Department d where d.depname = :name
//	
//	//add a new column establishdate date;
//	
//	Department findByName(String depname);
//	
//	//find the latest department started
//	@Query("FROM Department d WHERE d.establishdate = (SELECT MAX(d2.establishdate) FROM Department d2")
//	//find the department having no manager
//	@Query("from department d where d.managerid is null")
//	//find the department(s) whose managerid is given
//	@Query("from department d where d.managerid=:givenmanagerid")
//	//find the department(s) whose manager name is given
//	@Query("from department d where d.managerid=(from department d2.departmentid where d2.department_name=givendepartmentname")
}
