package com.dpw.migration;

import com.dpw.entity.Employee;
import com.dpw.repository.EmployeeRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@ChangeUnit(id="inserting-employee", order = "001", author = "mongock")
@Slf4j
@AllArgsConstructor
public class V001_InsertDummyEmployee {

	private final EmployeeRepository employeeRepository;

	@Execution
	public void migrationMethod() {
		log.info("before inserting employee.");
		Employee employee = new Employee();
		employee.setId("id01");
		employee.setName("RandomPerson1");
		employee.setDepartment("RandomDepartment1");
		employee.setSalary(1000);
		employeeRepository.save(employee);
	}
	@RollbackExecution
	public void rollback() {
		employeeRepository.deleteById("id01");
	}


}
