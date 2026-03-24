package com.saurabh.api.converter;

import com.saurabh.model.Training;

public class TrainingConverter {

	public static TrainingDto convert(Training training) {
		return new TrainingDto();
	}
	public static Training convert(TrainingDto dto) {
		return new Training();
	}
}
