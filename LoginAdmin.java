package com.abd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("adminId"));
		String password=request.getParameter("adminPassword");
		String name=AdminDAO.getAdminName(id);
		HttpSession session=request.getSession();
		session.setAttribute("id", id);
		if(AdminDAO.isThereSuchAnAdmin(id, password)) {
			request.setAttribute("welcome", "Welcome "+name);
			RequestDispatcher r=request.getRequestDispatcher("AdminPage.jsp");
			r.forward(request,response);
		}
		else {
			request.setAttribute("message", "Incorrect Password or user name...try again"); 
			RequestDispatcher r=request.getRequestDispatcher("AdminLogin.jsp");
			r.forward(request, response);
		}
	}
}
