package com.saurabh.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.saurabh.model.Issue;
import com.saurabh.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService service;
    
    @Test
    void testGetAllIssues() throws Exception {

        Issue issue = new Issue(1, null, "cloud issue", LocalDate.now(), false);

        when(service.getAll(1)).thenReturn(List.of(issue));

        mockMvc.perform(get("/all/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].issueType").value("cloud issue"));
    }
    @Test
    void testGetAllCurrentMonthIssues() throws Exception {

        Issue issue = new Issue(1, null, "network issue", LocalDate.now(), false);

        when(service.getAllCurrentMonthIssues()).thenReturn(List.of(issue));

        mockMvc.perform(get("/issue/current"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].issueType").value("network issue"));
    }
    @Test
    void testGetEmployeeNames() throws Exception {

        when(service.getEmployeeNames())
                .thenReturn(Arrays.asList("Saurabh", "Rahul"));

        mockMvc.perform(get("/employees/issues/current"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("Saurabh"));
    }
}
