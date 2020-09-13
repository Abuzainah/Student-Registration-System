package com.abd;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Drop")
public class Drop extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int studentId=(Integer)session.getAttribute("abc");
		int courseId=Integer.parseInt(request.getParameter("courseIdtoDrop"));
		
		System.out.println(studentId);
		System.out.print(courseId);
				
		if(EnrollmentDAO.isThereSuchARecord(studentId, courseId)) {
			EnrollmentDAO.deleteFromEnrollment(courseId, studentId);
			request.setAttribute("isDropped", "The course has been dropped");
			request.getRequestDispatcher("Drop.jsp").forward(request,response);	
		}
		
		else {
			request.setAttribute("isDropped", "You're either not registered in this course or you entered the worng ID of the course you want to drop");
			request.getRequestDispatcher("Drop.jsp").forward(request,response);	
		}
	}
}
