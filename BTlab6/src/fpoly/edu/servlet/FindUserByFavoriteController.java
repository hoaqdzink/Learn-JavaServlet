package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.dao.UserDao;


@WebServlet("/FindUserByFavoriteController")
public class FindUserByFavoriteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/FindUserByFavorite.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");
		
		UserDao dao = new UserDao();
		var user = dao.findUserByFavorite(videoId);
		
		request.setAttribute("users", user);
		request.getRequestDispatcher("/views/FindUserByFavorite.jsp").forward(request, response);
	}

}
