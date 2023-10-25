package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentsToUpdateEJBLocal 
{

	public String studentToUpdate(HttpServletRequest request,String id)throws ClassNotFoundException, SQLException;
}
