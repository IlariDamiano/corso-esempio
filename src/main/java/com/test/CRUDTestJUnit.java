package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

class CRUDTestJUnit {

	@Test
	void testAddStudent() throws ClassNotFoundException, SQLException 
	{
		
		int nRowsInserted = 0;
		Connection connection = DAOSingleton.getSingletonConnection();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		StudentDTO studentDTO = new StudentDTO("Salvatore","Franceschini",65);
		
		nRowsInserted = studentDAO.addStudent(SqlScript.sqlInsert, connection, studentDTO);
		
		assertEquals(nRowsInserted,1);
		
		
		
	}
	
	@Test
	void testFindAllStudents() throws ClassNotFoundException, SQLException 
	{
		ArrayList<StudentVO> studentVOs = new ArrayList<>();

		Connection connection = DAOSingleton.getSingletonConnection();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		
		studentVOs = studentDAO.findAllStudents(SqlScript.sqlRead, connection);
		
		assertEquals(studentVOs.size(), 10);
	}

}
