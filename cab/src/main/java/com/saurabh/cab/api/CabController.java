package com.saurabh.cab.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.cab.dao.CabRepository;
import com.saurabh.cab.dto.CabRequest;
import com.saurabh.cab.model.Cab;
import com.saurabh.cab.model.CabAllocation;
import com.saurabh.cab.service.CabService;

@RestController
public class CabController {
	
	private static final Logger log = LoggerFactory.getLogger(CabController.class);
	@Autowired
	CabService service;
	
	@Autowired
	CabRepository cabRepo;
	
	
	@PostMapping("/addCab")
	public Cab addCab(@RequestBody Cab cab) {
	    return cabRepo.save(cab);
	}
	
	@PostMapping("/cab")
	Boolean addCab(@RequestBody CabRequest request) {
		return service.addCab(request.getEmpList(), request.getBookDate());
	}
	@GetMapping("/bookings/{empId}")
	public List<CabAllocation> getBookings(@PathVariable Integer empId) {
	    return service.getAllBookingsByEmpId(empId);
	}
	@GetMapping("/cab/{cabid}")
	public Cab getCab(@PathVariable Integer cabid) {
		Optional<Cab> existing =  cabRepo.findById(cabid);
		if(existing.isEmpty()) {
			log.error("this cab not exist"); 
			throw new RuntimeException("Cab	 not found");
		}
		return existing.get();
	}
}
