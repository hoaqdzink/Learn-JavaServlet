package fpoly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpoly.edu.common.PageInfo;
import fpoly.edu.common.PageType;
import fpoly.edu.common.SessionUtils;
import fpoly.edu.dao.UserDao;
import fpoly.edu.domain.ChangePasswordForm;
import fpoly.edu.model.User;

@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		if (username == null) {
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
			return;
		}
		request.setAttribute("username", username);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(request);
			
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			request.setAttribute("username", username);
			
//			if (!form.getConfirmPassword().equals(form.getPassword())) {
//				request.setAttribute("error", "new password and new confirm password are not identical");
//			}else {
//				UserDao dao = new UserDao();	
//				dao.changePassword(username,form.getCurrentPassword(), form.getPassword());
//				request.setAttribute("message", "Password has been changed!");
//			}
			// kiểm tra cho các trường nhập mật khẩu mới và xác nhận mật khẩu
	        if (form.getPassword() == null || form.getPassword().trim().isEmpty()) {
	            request.setAttribute("error", "Please enter a new password");
	            PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	            return;
	        }

	        if (form.getConfirmPassword() == null || form.getConfirmPassword().trim().isEmpty()) {
	            request.setAttribute("error", "Please confirm your new password");
	            PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	            return;
	        }
	        
			UserDao userDao = new UserDao();
			User user = userDao.findById(username);

			if (user != null && user.getPassword().equals(form.getCurrentPassword())) {
			    // Mật khẩu hiện tại đúng, tiếp tục thực hiện thay đổi mật khẩu
			    if (!form.getConfirmPassword().equals(form.getPassword())) {
			        request.setAttribute("error", "New password and new confirm password are not identical");
			    } else {
			        userDao.changePassword(username, form.getCurrentPassword(), form.getPassword());
			        request.setAttribute("message", "Password has been changed!");
			    }
			} else {
			    // Mật khẩu hiện tại không đúng
			    request.setAttribute("error", "Current password is incorrect");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: "+ e.getMessage());
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}
