package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.model.Employee;
import com.saurabh.model.Issue;
import com.saurabh.repo.EmployeeRepo;
import com.saurabh.repo.IssueRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	IssueRepo repo;
	@Autowired
	EmployeeRepo erepo;

	@Override
	public Issue addIssue(Issue issue) {
		Integer empId = issue.getEmployee().getEmpId();
	    
	    Employee emp = erepo.findById(empId)
	                     .orElseThrow(() -> new RuntimeException("Employee not found"));
	    
	    issue.setEmployee(emp);
	    
	    return repo.save(issue);
	}

	@Override
	public List<Issue> getAll(int empId) {
		return repo.getAll(empId);
	}
	@Override
    public List<Issue> getAllCurrentMonthIssues() {
        return repo.getAllCurrentMonthIssues();
    }
	@Override
	public List<String> getEmployeeNames() {
	    return repo.getEmployeeNames();
	}
}