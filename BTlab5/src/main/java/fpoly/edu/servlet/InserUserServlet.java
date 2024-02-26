package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpoly.edu.model.User;
import fpoly.edu.dao.UserDao;


@WebServlet("/InserUserServlet")
public class InserUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			user.setAdmin(true);
			user.setEmail("vinhnh.2312@gmail.com");
			user.setPassword("1234");
			user.setUserId("vinhnh");
			user.setFullname("Nguyễn Hoàng Vinh");
			
			UserDao dao = new UserDao();
			dao.insertUser(user);
			
			response.getWriter().println("<h1>User saved!</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
