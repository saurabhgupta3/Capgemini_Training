package com.assess.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	int Sid;
	public String Sname;
	double Srank;
	String city;
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public double getSrank() {
		return Srank;
	}
	public void setSrank(double srank) {
		Srank = srank;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
