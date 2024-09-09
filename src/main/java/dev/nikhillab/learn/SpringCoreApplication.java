package dev.nikhillab.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import dev.nikhillab.learn.jpa.InstructorDAO;
import dev.nikhillab.learn.jpa.StudentDAO;
import dev.nikhillab.learn.jpa.mappings.Course;
import dev.nikhillab.learn.jpa.mappings.Instructor;
import dev.nikhillab.learn.jpa.mappings.InstructorDetails;

@SpringBootApplication
public class SpringCoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	InstructorDAO instructorDAO;

	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("CommandLineRunner run method");

		// var stu=new Student("Nikhil","Kumar","nikhil@gmail.com");
		// studentDAO.save(stu);
		// System.out.println(stu);
		// var stu1=new Student("Nikhil1","Kumar1","nikhil@gmail.com");
		// studentDAO.save(stu1);
		// System.out.println(stu1);
		// System.out.println(studentDAO.findById(1l));
		// System.out.println(studentDAO.findById(5l));
		// stu1.setFirstName("Demo");
		// studentDAO.update(stu1);
		// var stu2=new Student("NikhilDel","Del","nikhil@gmail.com");
		// studentDAO.save(stu2);
		// System.out.println(studentDAO.findAll());
		// studentDAO.delete(3l);
		// System.out.println(studentDAO.findAll());

		var instructorDetails = new InstructorDetails("demo_channal", "learning");
		var instructor = new Instructor("demofirst", "demolast", "demo@email.com", instructorDetails);

		// System.out.println(instructorDAO.findById(1l));

		var instructorDetails1 = new InstructorDetails("demo_channal1", "learning1");
		var instructor1 = new Instructor("demofirst1", "demolast1",
				"demo1@email.com", instructorDetails1);
		instructorDAO.save(instructor1);

		// instructorDAO.deleteById(1l);
		// // System.out.println(instructorDAO.findAll());

		// var insdr = instructorDAO.findInstructorDetailsById(2l);
		// System.out.println(insdr);
		// System.out.println(insdr.getInstructor());

		Course course = new Course("My Course0");
		Course course1 = new Course("My Course1");
		instructor.addCourses(course);
		instructor.addCourses(course1);

		instructorDAO.save(instructor);
		// System.out.println(instructorDAO.findAllCourse());

		// var res=instructorDAO.findById(2l);
		// var cor=instructorDAO.findCoursesByInstructor(2l);
		// System.out.println(cor);
		// res.setCourses(cor);

		// System.out.println(res.getCourses());
		// System.out.println(res);

		// System.out.println(instructorDAO.findInstructorByIdJoinFetchCourses(2l).getCourses());
		
		// res.setLastName("TEST_DEMO");
		// instructorDAO.update(res);
		// System.out.println(instructorDAO.findById(2l));

		instructorDAO.deleteById(2l);

	}

}
