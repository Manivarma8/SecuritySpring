package com.Krishna.demo.Krishna.Exception;

public class MyException  extends RuntimeException{
	String message;
public MyException(String message) {

	super(message);
	this.message = message;
	}}
