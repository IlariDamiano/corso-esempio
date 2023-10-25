package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ejb.StudentsToUpdateEJBLocal;



@WebServlet("/toUpdate")
public class StudentToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
@EJB
private StudentsToUpdateEJBLocal studentsToUpdateEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		
		try {
			response.sendRedirect(studentsToUpdateEJB.studentToUpdate(request, id));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
