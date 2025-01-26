package com.springbootdemo.mycoolapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootdemo.mycoolapp.entity.Student;

import jakarta.persistence.EntityManager;
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

}
