package com.example.crudApiStarter.entity;

import org.springframework.data.annotation.Id;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
//@Table(name="User")

@Document(collection = "User")
public class User {
	
//	@Id
//	//@Column
	
	@Id
	private String id;
	
	//@Column
	private String name;
	
	//@Column
	private String location;
	
	public User() {
		
	}
	
	public User(String id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
