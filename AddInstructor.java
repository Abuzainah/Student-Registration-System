package com.abd;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddInstructor")
public class AddInstructor extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String password=request.getParameter("password");
		
		if(Admin.createInstructor(id, firstName, lastName, password)) {
			HttpSession session =request.getSession();
			session.setAttribute("name", "Welcome "+firstName+" "+lastName);
			request.setAttribute("successMessage", "Instructor was added successfully");
			request.getRequestDispatcher("AddInstructor.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Something went wrong...try again later please");
			request.getRequestDispatcher("AddInstructor.jsp").forward(request, response);
		}
	}
}
