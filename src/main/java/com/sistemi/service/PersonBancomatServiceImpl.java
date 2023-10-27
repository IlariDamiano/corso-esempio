package com.sistemi.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemi.entity.Bancomat;

import com.sistemi.entity.Person;
import com.sistemi.repository.BancomatRepository;
import com.sistemi.repository.PersonRepository;

import jakarta.transaction.Transactional;



@Service
public class PersonBancomatServiceImpl implements personBancomatService
{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BancomatRepository bancomatRepository;
	
	@Autowired
	private PersonRepository personRepository;
	@Value("${message.save.success}")
    private String saveSuccess;

    @Value("${message.save.fail}")
    private String saveFail;

    @Value("${message.remove.success}")
    private String removeSuccess;

    @Value("${message.remove.fail}")
    private String removeFail;

    @Value("${message.read.fail}")
    private String readFail;

	@Override
	public void saveOrUpdatePerson(Person person) {
		if(person!=null && personRepository.save(person).getCodiceFiscale() == person.getCodiceFiscale())
		{
			logger.info(saveSuccess);
		} 
		else
			logger.info(saveFail);
		
	}

	@Override
	public void saveOrUpdateBancomat(Bancomat bancomat) {
		if(bancomat!=null && bancomatRepository.save(bancomat).getCodeNumber() == bancomat.getCodeNumber())
		{
			logger.info(saveSuccess);
		} 
		else
			logger.info(saveFail);
		
	}

	@Override
	public void removePersonAndBancomat(String codiceFiscale) {
		if(codiceFiscale !=null && personRepository.existsById(codiceFiscale))
		{
			personRepository.deleteById(codiceFiscale);
			if(!personRepository.existsById(codiceFiscale))
				logger.info(removeSuccess);

				else
					logger.info("sas");
				
		}
		else
			logger.info(removeFail);
		}
		


	@Transactional
	@Override
    public void removeBancomat(String codeNumber) {

        bancomatRepository.deleteBancomat(codeNumber);

    }
		
	
	
	@Override
	public void findAllPerson() {
		List<Person> peopleList = personRepository.findAll();
		List<Bancomat> bancomatList = bancomatRepository.findAll();
		
		if(!peopleList.isEmpty()&&!bancomatList.isEmpty())
			System.out.println("Persons:");
        for (Person person : peopleList) 
        {
            System.out.println(person);
            // Access the associated bancomat if needed
            Bancomat associatedBancomat = person.getBancomat();
            if (associatedBancomat != null) 
            {
                System.out.println(associatedBancomat);
            }
            else 
            	logger.info(readFail);
            }
		
        }
	@Override
    public Person findPersonByBancomat(Bancomat bancomat) {

        return personRepository.findByBancomat(bancomat);

    }
	@Override
	public Bancomat findBancomatByPerson(Person person)
	{
		return bancomatRepository.findByPerson(person);
	}
}
