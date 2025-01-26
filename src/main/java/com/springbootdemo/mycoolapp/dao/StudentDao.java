package com.springbootdemo.mycoolapp.dao;

import java.util.List;

import com.springbootdemo.mycoolapp.entity.Student;

public interface StudentDao {

    void save(Student thStudent);

    Student findById(int theId);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void deleteById(int theId);

    int deleteAll();
}
