package com.saurabh.cab.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class CabRequest {
	private List<Integer> empList;
    private LocalDate bookDate;
	public List<Integer> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Integer> empList) {
		this.empList = empList;
	}
	public LocalDate getBookDate() {
		return bookDate;
	}
	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}
}
