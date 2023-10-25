package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dto.StudentDTO;
import com.ejb.StudentsUpdateEJBLocal;


@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @EJB
  private StudentsUpdateEJBLocal studentsUpdateEJB;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));
	
		try {
			response.sendRedirect(studentsUpdateEJB.updateStudent(request,studentDTO,id));
		} catch (NumberFormatException | ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
