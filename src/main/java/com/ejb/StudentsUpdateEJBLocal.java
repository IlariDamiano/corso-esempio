package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import com.dto.StudentDTO;

@Local
public interface StudentsUpdateEJBLocal {
	public String updateStudent(HttpServletRequest request,StudentDTO studentDTO,String id)
			throws ClassNotFoundException,NumberFormatException, SQLException;

}
