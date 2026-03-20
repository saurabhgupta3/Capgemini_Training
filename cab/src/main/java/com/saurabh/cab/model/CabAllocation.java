package com.saurabh.cab.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CabAllocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  
	private Integer cabId;
	private Integer empId;
	private LocalDate bookDate;
	public Integer getCabId() {
		return cabId;
	}
	public CabAllocation() {
	}
	public CabAllocation(Integer cabId, Integer empId, LocalDate bookDate) {
		super();
		this.cabId = cabId;
		this.empId = empId;
		this.bookDate = bookDate;
	}
	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public LocalDate getBookDate() {
		return bookDate;
	}
	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}
	
	
}
