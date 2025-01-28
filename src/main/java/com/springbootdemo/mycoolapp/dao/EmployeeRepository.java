package com.springbootdemo.mycoolapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo.mycoolapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need to write any code
}
