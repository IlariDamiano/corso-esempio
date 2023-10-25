package com.ejb;


import java.sql.Connection;
import com.page.*;
import java.sql.SQLException;

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
public class StudentsToUpdateEJB implements StudentsToUpdateEJBLocal {
	


	@Override
	public String studentToUpdate(HttpServletRequest request, String id) 
			throws ClassNotFoundException, SQLException {
		
		
		HttpSession session;
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		Connection connection = DAOSingleton.getSingletonConnection();
		
		StudentVO studentVO = studentDAO.findStudentByID(SqlScript.sqlByIDString, connection, Integer.parseInt(id));
			
		
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {

            ConnectionManager.closeConnection(connection);
        }
		
		String page = Page.error;
		if(studentVO!=null)
		{
			session = request.getSession();
			session.setAttribute(SessionKey.studentsToUploadKey, studentVO);
			page = Page.studentUpdateString;
		}
		return page;
	}


}
