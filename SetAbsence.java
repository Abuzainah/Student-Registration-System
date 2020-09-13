package com.abd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetAbsence")
public class SetAbsence extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		int courseId=Integer.parseInt(request.getParameter("CourseID"));
		
		if(EnrollmentDAO.isThereSuchARecord(studentId, courseId)) {
			InstructorDAO.increaseAbsenceForAStudent(studentId,courseId);
			request.setAttribute("complete", "process completed");
			RequestDispatcher dispatcher=request.getRequestDispatcher("setAbsenceForStudent.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("Incomplete", "Make sure you entered the right ID for student and course");
			RequestDispatcher dispatcher=request.getRequestDispatcher("setAbsenceForStudent.jsp");
			dispatcher.forward(request, response);
		}
	}

}
