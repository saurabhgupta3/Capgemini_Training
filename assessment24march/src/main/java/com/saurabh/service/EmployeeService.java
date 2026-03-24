package com.saurabh.service;

import java.util.List;

import com.saurabh.model.Issue;

public interface EmployeeService {
	Issue addIssue(Issue issue);
	List<Issue> getAll(int empId);
	List<Issue> getAllCurrentMonthIssues();
	List<String> getEmployeeNames();
}
