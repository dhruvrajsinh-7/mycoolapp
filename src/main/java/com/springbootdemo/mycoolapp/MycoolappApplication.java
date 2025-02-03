package com.springbootdemo.mycoolapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication (
// 	scanBasePackages = {"com.springBootdemo.mycoolapp", "com.springBootdemo.util" })
import org.springframework.context.annotation.Bean;

import com.springbootdemo.mycoolapp.dao.AppDAO;
import com.springbootdemo.mycoolapp.entity.Instructor;
import com.springbootdemo.mycoolapp.entity.InstructorDetail;
import com.springbootdemo.mycoolapp.entity.Student;
@SpringBootApplication        
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return args -> {
			// createInstance(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructordetail(appDAO);
			deleteInstructordetail(appDAO);
		};
	}

	 private void createInstance(AppDAO appDAO) {
		// Instructor tempinstructor = new Instructor("John", "Doe", "JohnDoe@email.com");

		// InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "coding");

		Instructor tempinstructor = new Instructor("wick", "mew", "wickmew@email.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtubacnde.com", "coding");


		tempinstructor.setInstructorDetail(tempInstructorDetail);



		System.out.println("Saving instructor: " + tempinstructor);
		appDAO.save(tempinstructor);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("the associated instructor detail: " + tempInstructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 3;
		Instructor tempInstructor = appDAO.findInstructorById(id);
		appDAO.deleteInstructorById(id);
		System.out.println("Deleted instructor: " + tempInstructor);
		System.out.println("the associated instructor detail: " + tempInstructor.getInstructorDetail());
	}


	private void findInstructordetail(AppDAO appDAO) {
		int id = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("InstructorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructordetail(AppDAO appDAO) {
		int id = 4;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Deleted instructorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
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
