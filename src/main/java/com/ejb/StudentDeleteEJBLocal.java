package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentDeleteEJBLocal {
	
	public String removeStudent(HttpServletRequest request,String id)
			throws ClassNotFoundException, SQLException;

}
