package com.springbootdemo.mycoolapp;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// @SpringBootApplication (
// 	scanBasePackages = {"com.springBootdemo.mycoolapp", "com.springBootdemo.util" })
import org.springframework.context.annotation.Bean;

import com.springbootdemo.mycoolapp.dao.AppDAO;
import com.springbootdemo.mycoolapp.entity.Course;
import com.springbootdemo.mycoolapp.entity.Instructor;
import com.springbootdemo.mycoolapp.entity.InstructorDetail;
import com.springbootdemo.mycoolapp.entity.Review;
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
			// deleteInstructordetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// finCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReview(appDAO);
			// retrieveCourseAndReviews(appDAO);
			// deleteCourseAndReviews(appDAO);
			// createCourseAndStudent(appDAO);
			// findCourseAndStudents(appDAO);
			// findCourseAndStudentsBystudentid(appDAO);
			// addNewCoursesToStudent(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void addNewCoursesToStudent(AppDAO appDAO) {
		int id = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(id);
		System.out.println("Student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());
		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Saved courses: " + tempStudent.getCourses());
		appDAO.update(tempStudent);
	}

	private void findCourseAndStudentsBystudentid(AppDAO appDAO) {
		int id = 1;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(id);
		System.out.println("Student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;
		Course tempCourse = appDAO.findCourseAndStudentsById(id);
		System.out.println("Course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
		Student tempStudent2 = new Student("Mary", "Public", "Maryben@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "appollio@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);

		System.out.println("Saved course: " + tempCourse);
		System.out.println("Saved students: " + tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("done");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
		System.out.println("deleted");
	}
 
	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course tempCourse = appDAO.findCourseAndReviewsById(id);
		System.out.println("Course: " + tempCourse);
		System.out.println("Reviews: " + tempCourse.getReviews());
	}

	private void createCourseAndReview(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
		System.out.println("Saved course: " + tempCourse);
		System.out.println("Saved reviews: " + tempCourse.getReviews());
		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		Course tempCourse = appDAO.findCourseById(id);
		appDAO.deleteCourseById(id);
		System.out.println("Deleted course: " + tempCourse);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course tempCourse = appDAO.findCourseById(id);
		System.out.println("Course: " + tempCourse);
		// System.out.println("the associated instructor: " + tempCourse.getInstructor());
		tempCourse.setTitle("Air Guitar - The ZERO TO HERO Guide");
		appDAO.update(tempCourse);
		System.out.println("Course: " + tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("the associated instructor detail: " + tempInstructor.getInstructorDetail());
		// System.out.println("the associated courses: " + tempInstructor.getCourses());
		tempInstructor.setFirstName("Bruce");
		tempInstructor.setLastName("Lee");
		appDAO.update(tempInstructor);
		System.out.println("Instructor: " + tempInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}

	private void finCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("the associated instructor detail: " + tempInstructor.getInstructorDetail());
		List<Course> courses = appDAO.findCoursesByInstrcutorId(id);
		// associate the courses with the instructor
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}


	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("the associated instructor detail: " + tempInstructor.getInstructorDetail());
		System.out.println("the associated courses: " + tempInstructor.getCourses());
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
		int id = 1;
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

	private void createInstructorWithCourses(AppDAO appDAO) {
		// Instructor tempinstructor = new Instructor("John", "Doe", "JohnDoe@email.com");

		// InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "coding");

		Instructor tempinstructor = new Instructor("jacky", "chan", "chinchan@email.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.chanyoutube.com", "chingchong");


		tempinstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempinstructor.add(tempCourse1);
		tempinstructor.add(tempCourse2);

		// save the instructor
		System.out.println("Saving instructor: " + tempinstructor);
		System.out.println("Saving courses: " + tempinstructor.getCourses());
		appDAO.save(tempinstructor);
		System.out.println("done");
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

	private void deleteStudent(AppDAO studentDao) {
		// delete a student
		System.out.println("Deleting student");
		int studentId = 3;
		studentDao.deleteStudentById(studentId);
		System.out.println("Deleted student with id: " + studentId);
	}

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
