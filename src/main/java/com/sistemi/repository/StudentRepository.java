package com.sistemi.repository;

import java.util.List;

import com.sistemi.entity.Student;

public interface StudentRepository 
{

	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void removeStudent(String id);
	public List<Student> findAllStudents();
	public List<Student> findAllStudentsByLastName(String lastName);
	public List<Student> findAllStudentsByFirstName(String firstName);
	public List<Student> findAllStudentsByAge(int eta);
}
