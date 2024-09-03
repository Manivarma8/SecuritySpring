package com.Krishna.demo.Krishna.Exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalException {
@ExceptionHandler(value = MyException.class)
@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public ResponseEntity<ReviseException> handleThem(){
	ReviseException RE = new ReviseException(400,"DONT REPEAT CONTENT",new Date());
	return new ResponseEntity<ReviseException>(RE, HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<Object> handleExceptions(MethodArgumentNotValidException ex) {
    Map<String, Object> body = new LinkedHashMap<>();
    List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
    for (int i = 0; i < allErrors.size(); i++) {
        FieldError fieldError = (FieldError) allErrors.get(i);
        String fieldName = fieldError.getField();
        String errorMessage = fieldError.getDefaultMessage();
        body.put(fieldName, errorMessage);
    }
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
}


}



