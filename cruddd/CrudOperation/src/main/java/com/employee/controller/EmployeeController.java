package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.serviceImpl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empService;

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee emp) {
		empService.save(emp);
		return "Employee added successfully";
	}

	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
		empService.update(id, emp);
		return "Employee updated successfully";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id, Employee emp) {
		empService.delete(id);
		return "Employee deleted successfully";
	}
}
