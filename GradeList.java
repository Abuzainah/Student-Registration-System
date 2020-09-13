package com.abd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GradeList")
public class GradeList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId=Integer.parseInt(request.getParameter("studentID"));
		if(StudentDAO.isThereSuchAStudent(studentId)) {
			ArrayList<Enrollment> enrollment=EnrollmentDAO.showGrades(studentId);
			request.setAttribute("gradeList", enrollment);
			RequestDispatcher dispatcher=request.getRequestDispatcher("StudentGradeList.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("errorEntry2", "There is no suck student, pleasee check the student ID again..");
			RequestDispatcher dispatcher=request.getRequestDispatcher("checkStudentGrades.jsp");
			dispatcher.forward(request, response);
		}
	}
}
