package com.sistemi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String>
{
	public Person findByBancomat(Bancomat bancomat);

}
