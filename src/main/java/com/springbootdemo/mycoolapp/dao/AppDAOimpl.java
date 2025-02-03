package com.springbootdemo.mycoolapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbootdemo.mycoolapp.entity.Course;
import com.springbootdemo.mycoolapp.entity.Instructor;
import com.springbootdemo.mycoolapp.entity.InstructorDetail;
import com.springbootdemo.mycoolapp.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOimpl implements AppDAO {

    EntityManager entityManager;

    public AppDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        // remove the associated courses
        instructor.getCourses().forEach(course -> course.setInstructor(null));
        
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // remove the associated instructor link 
        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstrcutorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                                    "select c from Course c where c.instructor.id=:data", Course.class);
        query.setParameter("data", id);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                                    "select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id=:data", Instructor.class);
        query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsById(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                                    "select c from Course c JOIN FETCH c.reviews where c.id=:data", Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentsById(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                                    "select c from Course c JOIN FETCH c.students where c.id=:data", Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                                    "select s from Student s JOIN FETCH s.courses where s.id=:data", Student.class);
        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional  
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}

