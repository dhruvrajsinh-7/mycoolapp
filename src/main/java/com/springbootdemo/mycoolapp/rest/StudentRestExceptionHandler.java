package com.springbootdemo.mycoolapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrrorResponse error = new StudentErrrorResponse();
        // return ResponseEntity
        error.setStatus(404);
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.NOT_FOUND);
        
    }

    // add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrrorResponse> handleException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrrorResponse error = new StudentErrrorResponse();
        // return ResponseEntity
        error.setStatus(400);
        // error.setMessage(exc.getMessage());
        error.setMessage("Bad Request");
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.BAD_REQUEST);
        
    }

}
