package com.saurabh.cab.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.cab.dao.CabAllocationRepo;
import com.saurabh.cab.dao.CabRepository;
import com.saurabh.cab.model.Cab;
import com.saurabh.cab.model.CabAllocation;

@Service
public class CabServiceImpl implements CabService {
	
	@Autowired
	CabRepository cRepo;
	@Autowired
    private CabAllocationRepo allocRepo;
	public Boolean addCab(List<Integer> empList, LocalDate bookDate) {
		int required = empList.size();
		List<Cab> cabs = cRepo.findAll();
		for (Cab cab : cabs) {
			boolean alreadyBooked = allocRepo
                    .existsByCabIdAndBookDate(cab.getId(), bookDate);
			if (alreadyBooked) continue;
			if (cab.getCapacity() >= required) {
				for (Integer empId : empList) {
                    CabAllocation allocation =
                            new CabAllocation(cab.getId(), empId, bookDate);

                    allocRepo.save(allocation);
                }
				return true;
			}
		}
		return false;
	}
	public List<CabAllocation> getAllBookingsByEmpId(Integer empId) {
        return allocRepo.findByEmpId(empId);
    }
}
