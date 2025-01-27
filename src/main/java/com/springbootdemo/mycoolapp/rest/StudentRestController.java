package com.springbootdemo.mycoolapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.mycoolapp.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define postconstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Hexa", "Hummer"));
        theStudents.add(new Student("Scott", "Tiger"));
        theStudents.add(new Student("Mary", "Lamb"));
    }

    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        // List<Student> students = new ArrayList<>();
        // students.add(new Student("Hexa", "Hummer"));
        // students.add(new Student("Scott", "Tiger"));
        // students.add(new Student("Mary", "Lamb"));
        // return students;
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // index into the list
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);

    }

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
