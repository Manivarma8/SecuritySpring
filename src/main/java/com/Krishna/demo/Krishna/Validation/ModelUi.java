package com.Krishna.demo.Krishna.Validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ModelUi {
	
	
	private Long id;
	@NotNull(message = "Type Something")
	@Size(min = 2, max = 20)
	private String name;
	@NotEmpty(message = "Must not be Empty and NULL")
	private String location;
//	@NotBlank(message = "Employee name can't be left empty")
	private Integer passedout;
	
	public ModelUi() {}
	public ModelUi(Long id, String name, String location, Integer passedout) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.passedout = passedout;
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
	
}
