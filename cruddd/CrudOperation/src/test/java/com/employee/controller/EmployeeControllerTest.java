package com.employee.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
	private MockMvc mockMvc; 
    @Autowired
    private EmployeeService employeeService;
    
    
    
    
}
