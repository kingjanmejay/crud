package com.employee.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest

class EmployeeRepositoryTest {
    @Autowired
	private TestEntityManager entityManager;
    
    @Autowired
    private EmployeeRepository employeeRepository;
	
    @Test
	public void testSave() {
		Employee employee = getEmployee();
		Employee savedInDb= entityManager.persist(employee);
		Employee getFromDb= employeeRepository.findByEmpId(savedInDb.getEmpId());
		assertThat(getFromDb).isEqualTo(savedInDb);
	}

	
	  @Test 
	  public void testUpdate() {
      Employee employee = getEmployee();
	  
	  entityManager.persist(employee);
	  
	  Employee fromDb = employeeRepository.findByName("Arjun");
	  fromDb.setName("Ramesh"); entityManager.persist(fromDb);
	  assertThat(fromDb.getName().equals("Arjun"));
	 
   }
	  @Test
	  public void testDelete() {
		  Employee employee1 =getEmployee();
		  Employee employee2 = new Employee();
		  employee2.setName("Nikhil");
		  employee2.setEmail("nikhil@xyz.com");
		  employee2.setLocation("Hyderabad");
		  employee2.setSalary(400000);
//		  Saving both Employee records into Database
		  Employee persist = entityManager.persist(employee1);
		  entityManager.persist(employee2);

//		  Deleting one Employee from database
		  entityManager.remove(persist);
		  
		Iterable<Employee>   allEmployeeFromDb = employeeRepository.findAll();
		List<Employee> newList = new ArrayList<Employee>();
		
		for(Employee employee : allEmployeeFromDb ) {
			 newList.add(employee);
		}
		  
		  assertThat(newList.size()).isEqualTo(1);
	  }
    
    private Employee getEmployee() {
    	Employee employee = new Employee();
    	employee.setName("Arjun");
    	employee.setEmail("arjun@xyz.com");
    	employee.setLocation("kolkata");
    	employee.setSalary(200000);
    	return employee;
    }
}


