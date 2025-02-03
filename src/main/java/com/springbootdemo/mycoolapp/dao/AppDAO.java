package com.springbootdemo.mycoolapp.dao;

import java.util.List;

import com.springbootdemo.mycoolapp.entity.Course;
import com.springbootdemo.mycoolapp.entity.Instructor;
import com.springbootdemo.mycoolapp.entity.InstructorDetail;
import com.springbootdemo.mycoolapp.entity.Student;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstrcutorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);
    
    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    Course findCourseAndStudentsById(int id);

    Student findStudentAndCourseByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);
    
}
