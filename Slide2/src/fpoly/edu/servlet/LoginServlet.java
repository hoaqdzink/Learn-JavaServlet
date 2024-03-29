package fpoly.edu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns =  {"/login","/checklogin"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("MESSAGE", "");
		RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String passWord = request.getParameter("password");
		User us = new User();
		
		if(us.checkLogin(username, passWord)) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/resultLogin.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("MESSAGE", "Username and passWord not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
		

	}

}
