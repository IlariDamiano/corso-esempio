package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person implements Serializable
{

	private static final long serialVersionUID = 6104398134763766359L;
	
	@Id
	@Column(name = "codice_fiscale", length = 16)
	private String codiceFiscale;
	
	private String name;
	private int age;
	
	@OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
	private Bancomat bancomat;
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String codiceFiscale, String name, int age) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.name = name;
		this.age = age;
	}
	protected Person()
	{
		
	}
	public Bancomat getBancomat() {
		return bancomat;
	}
	public void setBancomat(Bancomat bancomat) {
		this.bancomat = bancomat;
	}
	@Override
	public String toString() {
		return "Person [codiceFiscale=" + codiceFiscale + ", name=" + name + ", age=" + age + "]";
	}
	

}
