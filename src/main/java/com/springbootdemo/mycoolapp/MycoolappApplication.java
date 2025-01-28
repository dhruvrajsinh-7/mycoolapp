package com.springbootdemo.mycoolapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication (
// 	scanBasePackages = {"com.springBootdemo.mycoolapp", "com.springBootdemo.util" })
import org.springframework.context.annotation.Bean;

import com.springbootdemo.mycoolapp.entity.Student;
@SpringBootApplication        
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(StudentDao studentDao) {
	// 	return runner -> {
	// 		// createStudent(studentDao);
	// 		// createMultipleStudents(studentDao);
	// 		// queryStudent(studentDao);
	// 		// queryForStudentsByLastName(studentDao);
	// 		// updateStudent(studentDao);
	// 		// deleteStudent(studentDao);
	// 		// deleteAllStudents(studentDao);
	// 	};
	// }
			
	// private void deleteAllStudents(StudentDao studentDao) {
	// 	// delete all students
	// 	System.out.println("Deleting all students");
	// 	int numsRowDeleted = studentDao.deleteAll();
	// 	System.out.println("Deleted all students" + numsRowDeleted);
	// }

	// private void deleteStudent(StudentDao studentDao) {
	// 	// delete a student
	// 	System.out.println("Deleting student");
	// 	int studentId = 4;
	// 	studentDao.deleteById(studentId);
	// 	System.out.println("Deleted student with id: " + studentId);
	// }

	// private void updateStudent(StudentDao studentDao) {
	// 	//retrieve the student based on the id: primary key
	// 	int studentId = 1;
	// 	Student myStudent = studentDao.findById(studentId);
	// 	System.out.println("Retrieved student: " + myStudent);
	// 	// change some values
	// 	myStudent.setFirstName("Scooby");
	// 	myStudent.setLastName("Doo");
	// 	// update the student
	// 	studentDao.update(myStudent);
	// 	// display the student
	// 	System.out.println("Updated student: " + myStudent);
	// }

	// private void createMultipleStudents(StudentDao studentDao) {
	// 	// create multiple students
	// 	System.out.println("Creating new students");
	// 	Student myStudent1 = new Student("John","Doe");
	// 	Student myStudent2 = new Student("Mary","Public");
	// 	Student myStudent3 = new Student("Bonita","Applebum");


	// 	// save the students
	// 	System.out.println("Saving the students");
	// 	studentDao.save(myStudent1);
	// 	studentDao.save(myStudent2);
	// 	studentDao.save(myStudent3);

	// 	// dispaly the student ids
	// 	System.out.println("Saved student. Generated id: ");
	// 	readStudent(studentDao);
	// }

	// private void readStudent(StudentDao studentDao) {
	// 	// read a student
	// 	System.out.println("Reading the student");
	// 	Student myStudent = studentDao.findById(5);
	// 	// display the student
	// 	System.out.println(myStudent);
	// }

			
	// private void createStudent(StudentDao studentDao) {
	// 	// create a student
	// 	System.out.println("Creating new student");
	// 	Student myStudent = new Student("John","Doe");
	// 	// save the student
	// 	System.out.println("Saving the student");
	// 	studentDao.save(myStudent);
	// 	// dispaly the student id	
	// 	// System.out.println("Saved student. Generated id: " + myStudent.getId());

	// }
}
