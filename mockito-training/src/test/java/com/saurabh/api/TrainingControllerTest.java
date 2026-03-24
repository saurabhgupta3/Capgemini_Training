package com.saurabh.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.saurabh.model.Training;
import com.saurabh.service.TrainingService;

//@SpringBootTest
@WebMvcTest(TrainingController.class)
public class TrainingControllerTest {

	@MockitoBean
	TrainingService trainingService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void testFindById() throws Exception {
		Training t = new Training(101, Date.valueOf("2026-03-07"), Date.valueOf("2026-04-01"), "boss", "Shivaji");
		when(trainingService.findById(101)).thenReturn(t);

		mockMvc.perform(get("/training/101").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.trainingid").value("101")).andDo(res -> System.out.println(res.getResponse().getContentAsString()));
	}
}