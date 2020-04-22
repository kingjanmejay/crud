package com.employee.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void testSave() {
		Employee employee = getEmployee();

		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

		assertThat(employeeService.save(employee)).isEqualTo(employee);
	}

	@Test
	public void testUpdate() {

		Employee employee = getEmployee();

		Mockito.when(employeeRepository.findByEmpId((long) 12)).thenReturn(employee);
		employee.setName("Karan");
		employee.setEmail("karan@xyz.com");
		employee.setLocation("gurgaon");
		employee.setSalary(540000);

		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

		assertThat(employeeService.update((long) 12, employee)).isEqualTo(employee);

	}

	@Test
	public void testDelete() {
		Employee employee = getEmployee();

		Mockito.when(employeeRepository.findByEmpId((long) 12)).thenReturn(employee);
		Mockito.when(employeeRepository.existsById(employee.getEmpId())).thenReturn(false);

		assertThat(employeeRepository.existsById(employee.getEmpId()));

	}

	public Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmpId((long) 12);
		employee.setName("Arjun");
		employee.setEmail("arjun@xyz.com");
		employee.setLocation("kolkata");
		employee.setSalary(200000);

		return employee;
	}
}
