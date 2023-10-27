package com.sistemi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;

public interface BancomatRepository extends JpaRepository<Bancomat, String>
{
	
	@Modifying
    @Query("delete from Bancomat b where b.codeNumber=:codeNumber")
    public void deleteBancomat(@Param("codeNumber") String codeNumber);
	
	public Bancomat findByPerson(Person person);
	
}
