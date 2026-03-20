package com.saurabh.cab.service;

import java.time.LocalDate;
import java.util.List;

import com.saurabh.cab.model.CabAllocation;

public interface CabService {
	Boolean addCab(List<Integer> empList, LocalDate bookDate);
	List<CabAllocation> getAllBookingsByEmpId(Integer empId);
}
