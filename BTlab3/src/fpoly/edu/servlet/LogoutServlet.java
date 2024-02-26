package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import fpoly.edu.common.CookieUtils;
import fpoly.edu.model.LoginUser;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, response);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginUser user = new LoginUser();
			
			BeanUtils.populate(user, request.getParameterMap());
			
			if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				
				request.setAttribute("message", "login successfuly!!!");
				
				if(user.isRemember()) {
					CookieUtils.add("username", user.getUsername(),2, response);
				}else {
					CookieUtils.add("username", user.getUsername(), 0, response);
				}
			}else {
				request.setAttribute("message", "Inalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
	}

}
