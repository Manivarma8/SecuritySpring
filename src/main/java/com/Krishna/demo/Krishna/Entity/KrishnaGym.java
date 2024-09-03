package com.Krishna.demo.Krishna.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KrishnaGym") 
public class KrishnaGym {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private Long id;
private String name;
private String location;
private Integer passedout;
private String role;
private Integer salary;
public KrishnaGym() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
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
public Integer getPassedout() {
	return passedout;
}
public void setPassedout(Integer passedout) {
	this.passedout = passedout;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
public KrishnaGym(Long id, String name, String location, Integer passedout, String role, Integer salary) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
	this.passedout = passedout;
	this.role = role;
	this.salary = salary;
}
}
