package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.sistemi.entity.Student;
import com.sistemi.service.StudentService;


@SpringBootApplication

public class SbJpaCrudApplication implements CommandLineRunner{

	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(SbJpaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student student1 = new Student("LRIDMN02R01H501B","Damiano","Ila",21);
		Student student2 = new Student("LRIMRO66R01H501B","Mau","Ila",58);
		Student student3 = new Student("LNDCNZ62R01H501B","Cin","Lan",60);
		studentService.addStudent(student1);
		studentService.addStudent(student2);
		studentService.addStudent(student3);
		
		
		Student studentToUpdate = new Student("LNDCNZ62R01H501B","Cinzia","Landolfo",61);
		studentService.updateStudent(studentToUpdate);
		
		studentService.removeStudent("LRIMRO66R01H501B");
		
		studentService.findAllStudents();
		
		studentService.findAllStudentsByLastName("Ila");
	
		 
		
		
	}

}
