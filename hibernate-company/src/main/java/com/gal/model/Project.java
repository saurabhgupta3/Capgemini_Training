package com.gal.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int projectId;

	@Column(name = "startDate")
	Date startDate;
	@Column(name = "endDate")
	Date endDate;
	double budget;
	String client;
	@OneToOne
	@JoinColumn(name = "managerid")
	Employee manager;

	@ManyToMany
	@JoinTable(name = "project_employee", joinColumns = { @JoinColumn(name = "projectid") }, inverseJoinColumns = {
			@JoinColumn(name = "employeeid") })
	List<Employee> employees = new ArrayList<>();

	public Project() {
	}

	public Project(String client, Date startDate, Date endDate, double budget, ProjectManager projectManager) {
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.manager = manager;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Employee getProjectManager() {
		return manager;
	}

	public void setProjectManager(Employee manager) {
		this.manager = manager;
	}

}
