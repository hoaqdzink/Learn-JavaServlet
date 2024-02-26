package fpoly.edu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/views/calculator.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double a = Double.parseDouble(request.getParameter("numberA"));
		double b = Double.parseDouble(request.getParameter("numberB"));
		String action = request.getParameter("action");
		double result = 0;
		
		switch(action) {
			case "+":
				result = a + b;
				break;
			case "x":
				result = a * b;
				break;
			case "-":
				result = a - b;
				break;
			case "/":
				result = a / b;
				break;				
		}
		request.setAttribute("number_A", a);
		request.setAttribute("number_B", b);
		request.setAttribute("Action", action);
		request.setAttribute("Result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/views/result.jsp");
		rd.forward(request, response);
	}

}
