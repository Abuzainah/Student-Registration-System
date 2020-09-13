package com.abd;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("courseId"));
		String courseName=request.getParameter("courseName");
		
		if(Admin.createCourse(id, courseName)) {
			
			HttpSession session =request.getSession();
			request.setAttribute("successMessage", "Course was added successfully");
			request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Something went wrong...try again later please");
			request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
		}
	}
}
