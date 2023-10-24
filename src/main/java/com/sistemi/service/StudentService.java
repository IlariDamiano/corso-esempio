package com.sistemi.service;

import com.sistemi.entity.Student;

public interface StudentService 
{
	public void addStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void removeStudent(String id);
	
	public void findAllStudents();
	
	public void findAllStudentsByLastName(String lastName);
	
	public void findAllStudentsByFirstName(String firstName);
	
	public void findAllStudentsByAge(int eta);
}
