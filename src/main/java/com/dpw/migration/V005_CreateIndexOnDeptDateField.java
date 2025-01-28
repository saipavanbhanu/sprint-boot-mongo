package com.dpw.migration;

import com.dpw.entity.Department;
import com.mongodb.client.MongoDatabase;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;


@ChangeUnit(id = "index_createdDate", order = "005", author = "mongock")
@Slf4j
@AllArgsConstructor
public class V005_CreateIndexOnDeptDateField {

	private final MongoDatabase mongoDatabase;

	@Execution
	public void migrationMethod() {
		mongoDatabase.getCollection("department").createIndex(new Document("createdDate", 1));
	}

	@RollbackExecution
	public void rollback() {

	}


}
