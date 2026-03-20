package com.saurabh.cab.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.cab.model.CabAllocation;

public interface CabAllocationRepo extends JpaRepository<CabAllocation, Integer>{
	boolean existsByCabIdAndBookDate(Integer cabId, LocalDate bookDate);
	List<CabAllocation> findByEmpId(Integer empId);
}
