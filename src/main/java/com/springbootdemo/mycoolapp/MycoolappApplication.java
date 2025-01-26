package com.springbootdemo.mycoolapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication (
// 	scanBasePackages = {"com.springBootdemo.mycoolapp", "com.springBootdemo.util" })
import org.springframework.context.annotation.Bean;

import com.springbootdemo.mycoolapp.dao.StudentDao;
import com.springbootdemo.mycoolapp.entity.Student;
@SpringBootApplication        
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			// createStudent(studentDao);
			createMultipleStudents(studentDao);
			};
	}
			
	private void createMultipleStudents(StudentDao studentDao) {
		// create multiple students
		System.out.println("Creating new students");
		Student myStudent1 = new Student("John","Doe","johndoe@gmail.com");
		Student myStudent2 = new Student("Mary","Public","MaryPublic@gmail.com");
		Student myStudent3 = new Student("Bonita","Applebum","BonitaApplebum@gmail.com");


		// save the students
		System.out.println("Saving the students");
		studentDao.save(myStudent1);
		studentDao.save(myStudent2);
		studentDao.save(myStudent3);

		// dispaly the student ids
		
	}
			
	private void createStudent(StudentDao studentDao) {
		// create a student
		System.out.println("Creating new student");
		Student myStudent = new Student("John","Doe","john@doe.com");
		// save the student
		System.out.println("Saving the student");
		studentDao.save(myStudent);
		// dispaly the student id	
		System.out.println("Saved student. Generated id: " + myStudent.getId());

	}
}
