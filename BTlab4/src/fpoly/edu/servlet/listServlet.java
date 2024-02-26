package fpoly.edu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.model.Item;

/**
 * Servlet implementation class listServlet
 */
@WebServlet("/listServlet.php")
public class listServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			List<Item> items = new ArrayList<>();
			
			items.add(new Item("Redmi Note 12C", "redmi12c.png", 980.0,0.5,formatdate.parse("12/05/2021")));
			items.add(new Item("Redmi Note 12 Pro", "redminote12pro.png", 1260.0,0.25,formatdate.parse("19/04/2022")));
			items.add(new Item("Ultra 23", "ultra23.png", 2600.0,0.15,formatdate.parse("21/01/2023")));
			items.add(new Item("Xiaomi 14 Pro", "xiaomi14pro.png", 1999.0,0.11,formatdate.parse("28/05/2023")));
			items.add(new Item("Samsung Zflip 5", "zflip5.png", 999.0, 0.2, formatdate.parse("23/12/2001")));
			request.setAttribute("itemlist", items);
			request.getRequestDispatcher("/views/layout/bai4.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
