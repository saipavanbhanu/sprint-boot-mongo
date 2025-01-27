package com.dpw.migration;

import com.dpw.entity.Department;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;


@ChangeUnit(id = "index_dept_name", order = "003", author = "mongock")
@Slf4j
@AllArgsConstructor
public class V003_CreateDeptIndexOnName {

	private final MongoTemplate mongoTemplate;

	@Execution
	public void migrationMethod() {
		mongoTemplate.indexOps(Department.class).ensureIndex(new Index().on("name", Sort.Direction.ASC));
	}

	@RollbackExecution
	public void rollback() {
		mongoTemplate.indexOps(Department.class).dropIndex("name_1");
	}


}
