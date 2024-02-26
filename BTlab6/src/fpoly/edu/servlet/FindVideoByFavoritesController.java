package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.dao.VideoDao;


@WebServlet("/FindVideoByFavoritesController")
public class FindVideoByFavoritesController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/FindVideoByFavorites.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDao dao = new VideoDao();
		
		var favorite = request.getParameter("favorite");
		var list = dao.findVideoByFavorite(Boolean.parseBoolean(favorite));
		
		request.setAttribute("videos", list);
		request.getRequestDispatcher("/views/FindVideoByFavorites.jsp").forward(request, response);
	}

}
