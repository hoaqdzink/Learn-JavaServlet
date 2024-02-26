package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.dao.VideoDao;

@WebServlet("/ReportFavoriteVideoController")
public class ReportFavoriteVideoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoDao dao = new VideoDao();
		var list = dao.report();
		
		request.setAttribute("reports", list);
		request.getRequestDispatcher("/views/ReportFavoriteVideos.jsp").forward(request, response);
	}

}
