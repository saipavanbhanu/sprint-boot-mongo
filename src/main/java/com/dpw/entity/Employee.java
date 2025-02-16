package com.dpw.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Data
public class Employee {
	@Id
	private String id;
	private String name;
	private String department;
	private double salary;
}
