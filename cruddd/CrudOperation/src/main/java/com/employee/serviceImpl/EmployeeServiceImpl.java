package com.employee.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee emp) {

		return employeeRepository.save(emp);
	}

	@Override
	public Employee update(Long id, Employee tempEemp) {
		Employee emp = employeeRepository.findByEmpId(id);
		if (emp.getEmpId() != null) {
			emp.setName(tempEemp.getName());
			emp.setEmail(tempEemp.getEmail());
			emp.setLocation(tempEemp.getLocation());
			emp.setSalary(tempEemp.getSalary());
		}
		return employeeRepository.save(emp);
	}

	@Override
	public void delete(Long id) {
		Employee emp = employeeRepository.findByEmpId(id);
		employeeRepository.delete(emp);
	}

}
