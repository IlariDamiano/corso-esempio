package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.StudentDTO;
import com.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO{
	
	@Override
	public int addStudent(String sql, Connection con, StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		
		//già inizializzato dal Connection Manager
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		//recuperare dal DTO le informazioni che servono per concretizzare i placeholder
		ps.setString(1,  studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		
		//sincronizzare
		return ps.executeUpdate();
		
		
		
	}

	@Override
	public int updateStudent(String sql, Connection con, StudentDTO studentDTO, int id) throws ClassNotFoundException, SQLException {
		
		//sql = "update student set first_name=? last_name=? age=? where id=?"
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		
		ps.setString(1,  studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		ps.setInt(4, id);
		
		return ps.executeUpdate();
		
	}
	
	@Override
	public int removeStudent (String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		
		//sql= "delete from student where id=?";
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		
		ps.setInt(1, id);
		
		return ps.executeUpdate();		
	}
	
	@Override
	public ArrayList<StudentVO> findAllStudents(String sql, Connection con) throws SQLException {
		
		ArrayList<StudentVO> students = new ArrayList<>();
		
		//sql select * from student;
		
		ResultSet rs = ConnectionManager.getResultSet(sql, con);
		
		StudentVO  studentVO = null;
		
		while (rs.next()) {
			
			/*
			 * Per ogni Oggetto del ResultSet effettuiamo
			 * una copia del suo contenuto all'interno
			 * di un Oggetto StudentVO che a differenza 
			 * dell'oggetto del ResultSet è Serializable
			 * in quanto la Classe StudnetVO implements Serializable
			 * (AZIONE FATTA DA NOI!!)
			 */
			
			studentVO= new StudentVO
					(rs.getInt("id"),
					 rs.getString("first_name"),
					 rs.getString("last_name"),
					 rs.getInt("age"));
			
			students.add(studentVO);
		}
		
		return students;
		
	}

	public StudentVO findStudentByID(String sql, Connection con, int id) 
			throws ClassNotFoundException, SQLException {
		StudentVO studentVO = null;
		PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(sql,con);
		preparedStatement.setInt(1, id);
		ResultSet rSet = preparedStatement.executeQuery();
		if(rSet.next()) 
		{
			studentVO = new StudentVO
					(rSet.getInt("id"),
					 rSet.getString("first_name"),
					 rSet.getString("last_name"),
					 rSet.getInt("age"));
			
		}
		return studentVO;
	}
}
