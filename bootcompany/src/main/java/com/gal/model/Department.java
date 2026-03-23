package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Department {
	@Id
	@Column(name="department_id")
	int departmentid;
	
	@Column(name="department_name")
	String deptname;
	
	@Column(name="manager_id")
	int managerid;
	
	@Column(name="establishdate")
	Date establishdate;

	public Date getEstablishdate() {
		return establishdate;
	}

	public void setEstablishdate(Date establishdate) {
		this.establishdate = establishdate;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", deptname=" + deptname + ", managerid=" + managerid + "]";
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
}
