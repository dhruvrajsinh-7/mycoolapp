package com.springbootdemo.mycoolapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootdemo.mycoolapp.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOimpl implements StudentDao {

    // define the entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentDAOimpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    //implement the save method
    @Override
    @Transactional
    public void save(Student thStudent) {
        entityManager.persist(thStudent);
    }

    //implement the findById method
    @Override
    public Student findById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    //implement the findAll method
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
        return theQuery.getResultList();
    }

    //implement the findByFirstName method
    @Override
    public List<Student> findByFirstName(String firstName) {
        return null;
    }

    //implement the findByLastName method
    @Override
    public List<Student> findByLastName(String lastName) {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        
        // set parameter
        theQuery.setParameter("theData", lastName);

        // get result list
        return theQuery.getResultList();
    }

    //implement the update method
    @Override
    @Transactional
    public void update(Student theStudent) {
        // update the student
        entityManager.merge(theStudent);
    }

    //implement the deleteById method
    @Override
    @Transactional
    public void deleteById(int theId) {
        //retrieve the student based on the id: primary key
        Student myStudent = entityManager.find(Student.class, theId);
        // delete the student
        entityManager.remove(myStudent);
    }

    //implement the deleteAll method
    @Override
    @Transactional
    public int deleteAll() {
        // create a query
        int numsRowDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();
        return numsRowDeleted;
    }
}
