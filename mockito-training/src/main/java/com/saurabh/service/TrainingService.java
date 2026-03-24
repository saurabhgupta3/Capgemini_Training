package com.saurabh.service;

import java.util.List;

import com.saurabh.model.Training;

public interface TrainingService {
	List<Training> findByTopic(String topic);
	Training findById(int trainingId);
	Training addTraining(Training training);
	Training updateTraining(Training training);
	boolean deleteTraining(int trainingId);
}
