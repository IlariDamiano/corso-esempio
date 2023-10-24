package com.sistemi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistemi.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository
{
	@PersistenceContext
	private EntityManager em;
	@Override
	public void addStudent(Student student)
	{ 
		/*
        
		Hibernate nel momento in cui vede l'invocazione del metodo persist
		comprende che deve effettuare una operazione di insert sul DB
		    
		Hibernate sa che per effettuare un'operazione sul DB
		occorre prima aprire una connessione al DB
		Hibernate si aspetta una istruzione specifica per aprire la connessione al DB:
		si aspetta l'apertura di un CONTESTO TRANSAZIONALE
		tramite @Transaction
		*/
		
		em.persist(student);
		
		/*
		Hibernate dopo l'apertura della connessione traduce il metodo persist
		nel seguente script SQL:
		insert into student(first_name, last_name, age) values ('student.getFirstName', 'student.getLastName', student.getAge)
		Hibernate chiude la connessione
		*/
	}
	@Override
	public void updateStudent(Student student)
	{
		  /*
	     
		quando viene invocato il metodo merge Hibernate assume che occorre
		aggiornare un record già esistente all'interno del DB,
		per cui esegue le seguenti azioni: 
		1) controlla se effettivamente il record esiste
		(verifica se esiste un record con la chiave primaria inserita all'interno
		dell'oggetto Entity, per cui nell'oggetto deve essere presente l'informazione
		della chiave primaria);
		2) se il record NON ESISTE Hibernate lancia una eccezione
		3) se il record ESISTE Hibernate esegue l'aggiornamento
		*/
		em.merge(student);
	}
	@Override
	public void removeStudent(String id)
	{
		Student student = em.find(Student.class, id);
		em.remove(student);
	}
	@Override
	public List<Student> findAllStudents()
	{
		return em.createNamedQuery("Student.findAllStudents",Student.class).getResultList();
		
	}
	@Override
	public List<Student> findAllStudentsByLastName(String lastName) 
	{
		return em.createNamedQuery("Student.findAllStudentsByLastName",Student.class).
				setParameter("lastName", lastName).getResultList();
		
	}
	@Override
	public List<Student> findAllStudentsByFirstName(String firstName) 
	{
		
		return em.createNamedQuery("Student.findAllStudentsByFirstName",Student.class).
				setParameter("firstName", firstName).getResultList();
		
	}
	@Override
	public List<Student> findAllStudentsByAge(int eta) 
	{
		return em.createNamedQuery("Student.findAllStudentsByAge",Student.class).
				setParameter("eta", eta).getResultList();
		 
	}

}
