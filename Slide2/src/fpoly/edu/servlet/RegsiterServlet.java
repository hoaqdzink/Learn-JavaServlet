package fpoly.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegsiterServlet
 */
@WebServlet(urlPatterns = { "/", "/checkregister" })
public class RegsiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/regsiter.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		String coutry = request.getParameter("country");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobbies");

		try(PrintWriter out = response.getWriter()){
			out.println("<h1> Username: " + username + "</h1>");
			out.println("<h1> Age: " + age + "</h1>");
			out.println("<h1> Coutry: " + coutry + "</h1>" );
			out.println("<h1> Gender: " + gender + "</h1>");
			out.println("<h1>");
			for(String item : hobby) {
				out.println(item + ", ");
			}
			out.println("</h1>");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/resultRegsiter.jsp");
		rd.forward(request, response);
	}

}
