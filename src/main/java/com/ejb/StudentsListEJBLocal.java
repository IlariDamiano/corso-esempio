package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentsListEJBLocal {

	public String FindAllStudents(HttpServletRequest request) throws ClassNotFoundException, SQLException;
}
