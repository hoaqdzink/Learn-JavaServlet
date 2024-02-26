package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.dao.UserDao;

@WebServlet("/FindFavouriteVideoController")
public class FindFavouriteVideoController extends HttpServlet {
     
    public FindFavouriteVideoController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/views/FindFavoriteVideos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		if(userId != null) {
			UserDao dao = new  UserDao();
			
			var user = dao.findById(userId);
			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("/views/FindFavoriteVideos.jsp").forward(request, response);
		
	}

}
