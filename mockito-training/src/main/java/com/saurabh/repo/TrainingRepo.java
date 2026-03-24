package com.saurabh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saurabh.model.Training;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Integer>{
	
}
