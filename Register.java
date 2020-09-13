package com.abd;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Student student=(Student)session.getAttribute("student");
		HttpSession session2=request.getSession();
		int userId=(Integer)session2.getAttribute("abc");
		int courseId=Integer.parseInt(request.getParameter("courseId"));
		int instructorId=Integer.parseInt(request.getParameter("instructorId"));
					
		if(CourseDAO.isThereSuchACourse(courseId)&&InstructorDAO.isThereSuchAnInstructor(instructorId)) {
					if(EnrollmentDAO.isThereSuchAnEnrollment(userId, courseId)) {
						EnrollmentDAO.addEnrollment(student, InstructorDAO.getInstructor(instructorId), CourseDAO.getCourse(courseId));
						request.setAttribute("x", "process completed");
						request.getRequestDispatcher("Register.jsp").forward(request,response);		
					}
					else {
						request.setAttribute("x", "you've already enrolled in this course");
						request.getRequestDispatcher("Register.jsp").forward(request,response);	
					}
				}
		
		else {
			
			request.setAttribute("x", "Make sure you entered the right ID for the course and the instructor");
			request.getRequestDispatcher("Register.jsp").forward(request,response);	
		}	
	}
				
}

