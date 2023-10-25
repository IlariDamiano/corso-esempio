package com.ejb;

import java.sql.Connection;
import com.page.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@Stateless
public class StudentsListEJB implements StudentsListEJBLocal {

	@Override
	public String FindAllStudents(HttpServletRequest request) 
			throws ClassNotFoundException, SQLException 
	{
		String page = Page.error;
		ArrayList<StudentVO> students = new ArrayList<>();
		Connection connection = DAOSingleton.getSingletonConnection();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		
		students = studentDAO.findAllStudents(SqlScript.sqlRead, connection);
		
		 if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) 
		 {

             ConnectionManager.closeConnection(connection);
         }
		
		
	
		if(!students.isEmpty()) 
		{
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsListKey, students);
			page = Page.studentsList;
			
		}	
			
			return page;

			
	}

  

}
