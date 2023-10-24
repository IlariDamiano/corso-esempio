package com.sistemi.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@NamedQueries
({
	@NamedQuery(name="Student.findAllStudents",query= "select s from Student s"),
	@NamedQuery(name="Student.findAllStudentsByLastName", query= "select s from Student s where s.lastName=:lastName"),
	@NamedQuery(name="Student.findAllStudentsByFirstName", query= "select s from Student s where s.firstName=:firstName"),
	@NamedQuery(name="Student.findAllStudentsByAge", query= "select s from Student s  where s.eta=:eta")
})

@Entity
@Table(name = "students")
public class Student implements Serializable
{
	private static final long serialVersionUID = -1588532061608162375L;
	
	@Id
	private String codiceFiscale;
	
	@Column(name="first_name", length = 40)
	private String firstName;
	
	@Column(name="last_name", length = 40)
	private String lastName;
	
	@Column(name="eta", length = 40)
	private int eta;

	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	protected Student()
	{
		
	}
	public Student(String codiceFiscale, String firstName, String lastName, int eta) {
	
		this.codiceFiscale = codiceFiscale;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "| codiceFiscale: " + codiceFiscale + ", firstName: " + firstName + ", lastName: " + lastName
				+ ", eta: " + eta + " |";
	}
	

}
