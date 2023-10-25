package com.vo;

import java.io.Serializable;

public class StudentVO implements Serializable{


	private static final long serialVersionUID = -5073966242698258649L;
	
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	protected StudentVO() {
		
	}
	
	
	
	public StudentVO(int id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
	
	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
	
}
