package com.saurabh.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer issueId;
	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	@JoinColumn(name="emp_id")
	Employee employee;
	String issueType;
	LocalDate issueDate;
	Boolean isResolved;
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public Issue(Integer issueId, Employee employee, String issueType, LocalDate issueDate, Boolean isResolved) {
		super();
		this.issueId = issueId;
		this.employee = employee;
		this.issueType = issueType;
		this.issueDate = issueDate;
		this.isResolved = isResolved;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public Boolean getIsResolved() {
		return isResolved;
	}
	public void setIsResolved(Boolean isResolved) {
		this.isResolved = isResolved;
	}
	
	
}
