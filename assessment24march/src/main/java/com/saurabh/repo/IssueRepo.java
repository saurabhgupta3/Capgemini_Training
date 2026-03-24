package com.saurabh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saurabh.model.Issue;

public interface IssueRepo extends JpaRepository<Issue, Integer> {

	@Query(value = "select * from issue where emp_id = :empId and is_resolved = false", nativeQuery = true)
	List<Issue> getAll(@Param("empId") int empId);
	
	@Query(value = "select * from issue where issue_date >= date_format(curdate(), '%Y-%m-01') and issue_date < date_format(curdate() + interval 1 month, '%Y-%m-01')", nativeQuery = true)
    List<Issue> getAllCurrentMonthIssues();	
	
	@Query(value = "select distinct e.name from issue i join employee e on i.emp_id = e.emp_id where i.issue_date >= date_format(curdate(), '%Y-%m-01') and i.issue_date < date_format(curdate() + interval 1 month, '%Y-%m-01')", nativeQuery = true)
	List<String> getEmployeeNames();
}