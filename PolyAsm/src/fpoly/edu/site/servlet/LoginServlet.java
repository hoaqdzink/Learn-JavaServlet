package fpoly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpoly.edu.common.CookieUtils;
import fpoly.edu.common.PageInfo;
import fpoly.edu.common.PageType;
import fpoly.edu.common.SessionUtils;
import fpoly.edu.dao.UserDao;
import fpoly.edu.domain.LoginForm;
import fpoly.edu.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Gọi cookie để lấy thông tin của username
		String username = CookieUtils.get("username", request);
		
		if (username == null) {
			request.setAttribute("isLogin", false);
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
			return;
		}
		SessionUtils.add(request, "username", username);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginForm loginf = new LoginForm();
			BeanUtils.populate(loginf, request.getParameterMap());
			
			UserDao dao = new UserDao();
			User user = dao.findById(loginf.getUsername());
			if (user!=null && user.getPassword().equals(loginf.getPassword())) {
				SessionUtils.add(request, "username", user.getUsername());
				
				if (loginf.isRemember()) {
					CookieUtils.add("username", loginf.getUsername(), 24, response);
				}else {
					CookieUtils.add("username", loginf.getUsername(), 0, response);
				}
				request.setAttribute("isLogin", true);
				request.setAttribute("name", user.getFullname());
				PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
				return;
			}
			request.setAttribute("error", "invalid username or password");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
	}

}
