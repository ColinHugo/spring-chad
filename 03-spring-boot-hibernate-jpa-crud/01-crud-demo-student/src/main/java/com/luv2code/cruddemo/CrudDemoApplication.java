package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.IStudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.MidiSystem;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner( IStudentDAO studentDAO ) {
		return runner -> {

			// createStudent( studentDAO );

			createMultipleStudents( studentDAO );

			// readStudent( studentDAO );

			// queryForStudents( studentDAO );

			// queryForStudentsByLastName( studentDAO );

			// updateStudent( studentDAO );

			// deleteStudent( studentDAO );

			// deleteAll( studentDAO );
		};
	}

	private void createMultipleStudents( IStudentDAO studentDAO ) {

		// create multiple students
		System.out.println( "Creating 3 student objects..." );
		Student tempStudent1 = new Student( "John", "Doe", "john@correo.com" );
		Student tempStudent2 = new Student( "Mary", "Public", "mary@correo.com" );
		Student tempStudent3 = new Student( "Bonita", "Applebum", "john@correo.com" );

		// save the student objects
		System.out.println( "Saving the students..." );
		studentDAO.save( tempStudent1 );
		studentDAO.save( tempStudent2 );
		studentDAO.save( tempStudent3 );
	}

	private void createStudent( IStudentDAO studentDAO ) {

		// create the student object
		System.out.println( "Creating new student object..." );
		Student tempStudent = new Student( "Hugo", "Colín", "hugo@correo.com" );

		// save the student object
		System.out.println( "Saving the student..." );
		studentDAO.save( tempStudent );

		// display id of the saved student
		System.out.println( "Saved student. Generated id: " + tempStudent.getId() );
	}

	private void readStudent( IStudentDAO studentDAO ) {

		// create a student object
		System.out.println( "Creating new student object..." );
		Student tempStudent = new Student( "Daffy", "Duck", "daffy@correo.com" );

		// save the student
		System.out.println( "Saving the student" );
		studentDAO.save( tempStudent );

		// display id of the saved student
		int id = tempStudent.getId();
		System.out.println( "Saved student. Generated id: " + id );

		// retrieve student based on the id: primary key
		System.out.println( "Retrieving student with id: " + id );
		Student myStudent = studentDAO.findById( id );

		// display student
		System.out.println("Found the student: " + myStudent );
	}

	private void queryForStudents( IStudentDAO studentDAO ) {

		// get lists of students
		List< Student > theStudents = studentDAO.findAll();

		// display list of students
		for ( Student student : theStudents ) {
			System.out.println( student );

		}
	}

	private void queryForStudentsByLastName( IStudentDAO studentDAO ) {

		// get a list of students
		List< Student > theStudents = studentDAO.findByLastName( "Duck" );

		// display list of students
		for ( Student student : theStudents ) {
			System.out.println( student );
		}
	}

	private void updateStudent( IStudentDAO studentDAO ) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println( "Getting student with id: " + studentId );
		Student myStudent = studentDAO.findById( studentId );

		// change first name to "Scooby"
		System.out.println( "Updating student..." );
		myStudent.setFirstName( "John" );

		// update the student
		studentDAO.update( myStudent );

		// display the updated student
		System.out.println( "Updated student: " + myStudent );
	}

	private void deleteStudent( IStudentDAO studentDAO ) {

		int studentId = 3;
		System.out.println( "Deleting student id: " + studentId );

		studentDAO.delete( studentId );
	}

	private void deleteAll(IStudentDAO studentDAO) {

		System.out.println( "Deleting all students" );
		int  numRows = studentDAO.deleteAll();
		System.out.println( "Deleted row count: " + numRows );
	}

}
