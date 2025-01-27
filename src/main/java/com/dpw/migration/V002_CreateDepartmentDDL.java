package com.dpw.migration;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id="creating_dept", order = "002", author = "mongock")
@Slf4j
@AllArgsConstructor
public class V002_CreateDepartmentDDL {

	private final MongoTemplate mongoTemplate;

	@Execution
	public void migrationMethod() {
		mongoTemplate.createCollection("department");
	}
	@RollbackExecution
	public void rollback() {
		mongoTemplate.dropCollection("department");
	}


}
