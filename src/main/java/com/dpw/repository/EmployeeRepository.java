package com.dpw.repository;

import com.dpw.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("employees")
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
