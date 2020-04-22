package com.employee.service;

import com.employee.model.Employee;

public interface EmployeeService {
	Employee save(Employee emp);

	Employee update(Long id, Employee emp);

	void delete(Long id);

}
