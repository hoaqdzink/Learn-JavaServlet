package fpoly.edu.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.model.Item;

/**
 * Servlet implementation class detailServlet
 */
@WebServlet("/detail.java")
public class detailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Item item = new Item("Samsung Zflip 5", "zflip5.png", 999.0, 0.2, formatdate.parse("23/12/2001"));
			request.setAttribute("ITEMS", item);
			request.getRequestDispatcher("/views/layout/bai3.jsp").forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
