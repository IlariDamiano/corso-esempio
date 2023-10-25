package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ejb.StudentsListEJBLocal;


@WebServlet("/studentsList")
public class StudentListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@EJB
	private StudentsListEJBLocal studentsListEJB;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		
		try {
			response.sendRedirect(studentsListEJB.FindAllStudents(request));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
