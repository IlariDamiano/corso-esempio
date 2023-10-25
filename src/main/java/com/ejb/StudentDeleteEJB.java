package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.page.*;
import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.key.SessionKey;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@Stateless
public class StudentDeleteEJB implements StudentDeleteEJBLocal {

	@Override
	public String removeStudent(HttpServletRequest request,String id) throws ClassNotFoundException, SQLException {
			HttpSession session;
		  StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		  ArrayList<StudentVO> students = new ArrayList<>();
		 
			Connection con  = DAOSingleton.getSingletonConnection();
			
			int nRowsDeleted = studentDAO.removeStudent(SqlScript.sqlDelete, con, Integer.parseInt(id));
			
			if(nRowsDeleted>0)
				students = studentDAO.findAllStudents(SqlScript.sqlRead, con);
		  
		  
		  if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {

               ConnectionManager.closeConnection(con);
           }
		
		  String page = Page.error;
		  
		  if(!students.isEmpty())
		  {
			  session = request.getSession();
			  session.setAttribute(SessionKey.studentsListKey, students);
			  page = Page.studentsList;
		  }
			 
	  
		return page;
	}

  
}
