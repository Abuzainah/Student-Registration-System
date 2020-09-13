package com.abd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetGrade")
public class SetGrade extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		int courseId=Integer.parseInt(request.getParameter("CourseID"));
		double grade=Double.parseDouble(request.getParameter("grade"));
		if(EnrollmentDAO.isThereSuchARecord(studentId, courseId)) {
			InstructorDAO.setGradeForAStudent(studentId, grade);
			request.setAttribute("complete", "process completed");
			
			HttpSession session = request.getSession();
			session.setAttribute("studentId", studentId);
			RequestDispatcher dispatcher=request.getRequestDispatcher("setGradeForStudent.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("Incomplete", "Make sure you entered the right ID for student and course");
			RequestDispatcher dispatcher=request.getRequestDispatcher("setGradeForStudent.jsp");
			dispatcher.forward(request, response);
		}
	}

}
