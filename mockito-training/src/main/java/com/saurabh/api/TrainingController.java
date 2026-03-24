package com.saurabh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.model.Training;
import com.saurabh.service.TrainingService;

@RestController
@RequestMapping("/training")
public class TrainingController {
	
	private TrainingService trainingService;
	
	@Autowired
	public TrainingController(TrainingService trainingService) {
		super();
		this.trainingService = trainingService;
	}
	
	@GetMapping("/{trainingId}")
	Training findById(@PathVariable int trainingId) {
		return trainingService.findById(trainingId);
	}
}
