package com.saurabh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeService.class)
public class EmployeeServiceTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	EmployeeService service;
	
	
}
