package com.abd;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InstructorLogin")
public class InstructorLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("ID"));
		String password = request.getParameter("password");
				
		
		if(InstructorDAO.isThereSuchAnInstructor(id, password)) {
			
			ArrayList<Enrollment>absenceList=EnrollmentDAO.showAbsense(id);
			HttpSession session5=request.getSession();
			session5.setAttribute("absence", absenceList);
			
			HttpSession session2 = request.getSession();
			session2.setAttribute("id", id);
			
			ArrayList<Enrollment>studentList=EnrollmentDAO.getStudentInstructorTeach(id);
			HttpSession session3=request.getSession();
			session3.setAttribute("studentList",studentList);
			
			ArrayList<Enrollment>courseList=EnrollmentDAO.getStudentInstructorTeach(id);
			HttpSession session4=request.getSession();
			session4.setAttribute("InstructorCourses",courseList);
			
			response.sendRedirect("InstructorPage.jsp");
		}
		
		else {
			request.setAttribute("errorMessage", "Incorrect username or password");
			request.getRequestDispatcher("InstructorLogin.jsp").forward(request, response);
		}
	}

}

