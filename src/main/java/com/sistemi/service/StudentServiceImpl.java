package com.sistemi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.sistemi.entity.Student;
import com.sistemi.repository.StudentRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class StudentServiceImpl implements StudentService
{
	 @Value("${message.insert.success}")
	 private String insertSuccess;
	 @Value("${message.insert.fail}")
     private String insertFail;

     @Value("${message.update.success}")
     private String updateSuccess;

     @Value("${message.update.fail}")
     private String updateFail;

     @Value("${message.delete.success}")
     private String deleteSuccess;

     @Value("${message.delete.fail}")
     private String deleteFail;

     @Value("${message.read.fail}")
     private String readFail;
     
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void addStudent(Student student) 
	{
		try {
			studentRepository.addStudent(student);
			logger.info(insertSuccess);
			
		} catch (IllegalArgumentException | EntityExistsException ex ) {
			logger.info(insertFail);
		}
		
		
	}

	@Override
	public void updateStudent(Student student) 
	{
		try {
			studentRepository.updateStudent(student);
			logger.info(updateSuccess);
			
		} catch (IllegalArgumentException  ex ) {
			logger.info(updateFail);
		}
		
		
	}

	@Override
	public void removeStudent(String id) 
	{
		try {
			studentRepository.removeStudent(id);
			logger.info(deleteSuccess);
			
		} catch (IllegalArgumentException  ex ) {
			logger.info(deleteFail);
		}
		
		
	}

	@Override
	public void findAllStudents() 
	{
		List <Student> studentsList = new ArrayList<>();
		try {
			studentsList = studentRepository.findAllStudents();
			if(!studentsList.isEmpty())			
			studentsList.forEach(students->logger.info(students.toString()));
			
		} catch (IllegalArgumentException  ex ) {
			logger.info(readFail);
		}
		
		
	}

	@Override
	public void findAllStudentsByLastName(String lastName) 
	{
		
		List <Student> studentsList = new ArrayList<>();
		try {
			studentsList = studentRepository.findAllStudentsByLastName(lastName);
			if(!studentsList.isEmpty())			
			studentsList.forEach(students->logger.info(students.toString()));
			
		} catch (IllegalArgumentException  ex ) {
			logger.info(readFail);
		}
	}

	@Override
	public void findAllStudentsByFirstName(String firstName) 
	{
		
		List <Student> studentsList = new ArrayList<>();
		try {
			studentsList = studentRepository.findAllStudentsByFirstName(firstName);
			if(!studentsList.isEmpty())			
			studentsList.forEach(students->logger.info(students.toString()));
			
		} catch (IllegalArgumentException  ex ) {
			logger.info(readFail);
		}
	}

	@Override
	public void findAllStudentsByAge(int eta) 
	{
		List <Student> studentsList = new ArrayList<>();
		try {
			studentsList = studentRepository.findAllStudentsByAge(eta);
			if(!studentsList.isEmpty())			
			studentsList.forEach(students->logger.info(students.toString()));
			
		} catch (IllegalArgumentException  ex ) {
			logger.info(readFail);
		}
		
		
	}

}
