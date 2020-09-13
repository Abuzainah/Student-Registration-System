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

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("ID"));
		String password = request.getParameter("password");
			
		try {
			if(StudentDAO.isThereSuchAStudent(id, password)) {
				HttpSession session13=request.getSession();
				session13.setAttribute("g", id);
				HttpSession seesion=request.getSession();
				seesion.setAttribute("abc", id);
				HttpSession session2=request.getSession();
				session2.setAttribute("student", StudentDAO.getStudent(id));
				ArrayList<Enrollment>gradeList=EnrollmentDAO.showGrades(id);
				HttpSession session5=request.getSession();
				session5.setAttribute("gradeList",gradeList);
				ArrayList<Enrollment>absenceList=EnrollmentDAO.showAbsense(id);
				HttpSession session6=request.getSession();
				session6.setAttribute("absenceList",absenceList);
				response.sendRedirect("StudentPage.jsp");	
			}
			else {
				request.setAttribute("message", "Incorrect Password or user name...try again"); // Will be available as ${message}
				request.getRequestDispatcher("StudentLogin.jsp").forward(request,response);					
			}
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

}
