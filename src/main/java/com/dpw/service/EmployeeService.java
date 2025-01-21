package com.dpw.service;

import com.dpw.entity.Employee;
import com.dpw.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public Employee getEmployeeById(String id) {
		return repository.findById(id).orElse(null);
	}

	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee updateEmployee(String id, Employee employee) {
		if (repository.existsById(id)) {
			employee.setId(id);
			return repository.save(employee);
		}
		return null;
	}

	public void deleteEmployee(String id) {
		repository.deleteById(id);
	}
}
