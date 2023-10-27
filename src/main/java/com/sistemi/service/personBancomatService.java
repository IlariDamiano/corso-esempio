package com.sistemi.service;

import com.sistemi.entity.Bancomat;

import com.sistemi.entity.Person;

public interface personBancomatService 
{
	
	
	
	public void saveOrUpdatePerson(Person person);
	public void saveOrUpdateBancomat(Bancomat bancomat);
	public void removePersonAndBancomat(String codiceFiscale);
	public void removeBancomat(String codeNumber);
	public void findAllPerson();
	public Person findPersonByBancomat(Bancomat bancomat);
	public Bancomat findBancomatByPerson(Person person);
	

}
