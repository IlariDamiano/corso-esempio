package com.sistemi;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;
import com.sistemi.service.personBancomatService;

@SpringBootApplication
public class SbDataJpaCrudOneToOneApplication implements CommandLineRunner
{

	@Autowired
	private personBancomatService pbService;
	public static void main(String[] args) {
		SpringApplication.run(SbDataJpaCrudOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
	
		Date date;
		
		Person person = new Person("LFSD54RDFD","Damiano Ilari",21);
		Person person1 = new Person("GDSG45SG","Francesco Boldrin",31);
		Person person2 = new Person("MJSDNGFSN34","Pippo Buado", 78);
		
		pbService.saveOrUpdatePerson(person);
		pbService.saveOrUpdatePerson(person1);
		pbService.saveOrUpdatePerson(person2);
		
		Bancomat bancomat = new Bancomat("3462", "Unicredit", date=Date.valueOf("2015-07-05"), "ITYfndnbfbdfbsa");
		Bancomat bancomat1 = new Bancomat("3470", "Mediolanum", date=Date.valueOf("2016-10-09"), "ITYfnererervvdv");
		Bancomat bancomat2 = new Bancomat("3480", "Intesa Sanpaolo", date=Date.valueOf("2018-12-24"), "ITYsasasasaass");
		
		bancomat.setPerson(person);
		bancomat1.setPerson(person1);
		bancomat2.setPerson(person2);
		
		pbService.saveOrUpdateBancomat(bancomat);
		pbService.saveOrUpdateBancomat(bancomat1);
		pbService.saveOrUpdateBancomat(bancomat2);
		
	
		pbService.findAllPerson();
		
		pbService.findBancomatByPerson(person1);
		pbService.removeBancomat("3480");
		pbService.removePersonAndBancomat("GDSG45SG");
		
		pbService.findAllPerson();
		
		
		
	}

}
