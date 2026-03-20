package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class EmployeeTransportDTO {
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;	
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public EmployeeTransportDTO(Employee emp) {
	    this.fName = emp.getfName();
	    this.lName = emp.getlName();
	    this.email = emp.getEmail();
	    this.phone = emp.getPhone();
	    this.address = emp.getAddress();
	}
	String fName;
	String lName;
	String email;
	String phone;
	String address;
}
