package com.Krishna.demo.Krishna.Exception;

import java.util.Date;

public class ReviseException {
	private Integer error;
private String message;
private Date date;
public ReviseException(Integer error, String message, Date date) {
	super();
	this.error = error;
	this.message = message;
	this.date = date;
}
public Integer getError() {
	return error;
}
public void setError(Integer error) {
	this.error = error;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



}
