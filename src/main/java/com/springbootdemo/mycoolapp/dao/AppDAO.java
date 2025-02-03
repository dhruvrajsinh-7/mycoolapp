package com.springbootdemo.mycoolapp.dao;

import com.springbootdemo.mycoolapp.entity.Instructor;
import com.springbootdemo.mycoolapp.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
