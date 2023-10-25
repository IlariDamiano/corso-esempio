package com.ejb;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.page.*;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@Stateless

public class StudentsUpdateEJB implements StudentsUpdateEJBLocal {

	@Override
	public String updateStudent(HttpServletRequest request,StudentDTO studentDTO,String id) 
			throws ClassNotFoundException, SQLException, NumberFormatException 
	{
		Connection con = null;
		HttpSession session = null;
		int nRowsUpdated = 0;
		ArrayList<StudentVO> studentVO = new ArrayList<>();
		
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstance();
		con = DAOSingleton.getSingletonConnection();
		nRowsUpdated = studentDAO.updateStudent(SqlScript.sqlUpdate, con, studentDTO, Integer.parseInt(id));
			if(nRowsUpdated>0)
				studentVO = studentDAO.findAllStudents(SqlScript.sqlRead, con);
			
			
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {

               ConnectionManager.closeConnection(con);
           }
		
		String page= Page.error;
		if(!studentVO.isEmpty())
		  {
			  session = request.getSession();
			  session.setAttribute(SessionKey.studentsListKey, studentVO);
			  page=Page.studentsList;
		  }
			  
		return page;
	}

    
}
