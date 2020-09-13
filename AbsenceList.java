package com.abd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AbsenceList")
public class AbsenceList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId=Integer.parseInt(request.getParameter("studentID"));
		if(StudentDAO.isThereSuchAStudent(studentId)) {
			HttpSession session=request.getSession();
			session.setAttribute("g", studentId);
			RequestDispatcher dispatcher=request.getRequestDispatcher("StudentAbsenceList.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("errorEntry", "There is no such student, please check the student ID again..");
			RequestDispatcher dispatcher=request.getRequestDispatcher("checkStudentsAbsence.jsp");
			dispatcher.forward(request, response);
		}
	}
}
