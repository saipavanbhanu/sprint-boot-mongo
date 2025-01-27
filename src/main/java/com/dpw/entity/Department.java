package com.dpw.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class Department {
	@Id
	private String id;
	private String code;
	private String name;
}
