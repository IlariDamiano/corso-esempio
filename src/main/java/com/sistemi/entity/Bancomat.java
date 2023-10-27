package com.sistemi.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Bancomat implements Serializable
{

	private static final long serialVersionUID = 6636292115771977361L;
	
	@Id
	@Column(name = "code_number")
	private String codeNumber;
	
	private String bank;
	
	@Column(name = "Expiry_date")
	private Date expiryDate;
	
	private String iBAN;
	
	@OneToOne
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getiBAN() {
		return iBAN;
	}

	public void setiBAN(String iBAN) {
		this.iBAN = iBAN;
	}

	public Bancomat(String codeNumber, String bank, Date expiryDate, String iBAN) {
		super();
		this.codeNumber = codeNumber;
		this.bank = bank;
		this.expiryDate = expiryDate;
		this.iBAN = iBAN;
	}
	protected Bancomat()
	{
		
	}

	@Override
	public String toString() {
		return "Bancomat [codeNumber=" + codeNumber + ", bank=" + bank + ", expiryDate=" + expiryDate + ", iBAN=" + iBAN
				+ "]";
	}
	
}
