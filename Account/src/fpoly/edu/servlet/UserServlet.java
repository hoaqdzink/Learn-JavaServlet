package fpoly.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpoly.edu.dao.UserDao;
import fpoly.edu.javamailsender.JavaMailForgotPass;
import fpoly.edu.model.User;


@WebServlet({"/","/UserServlet","/UserServlet/sign-up","/UserServlet/sign-out",
	"/UserServlet/sign-in","/UserServlet/forgot-password","/UserServlet/change-password",
	"/UserServlet/edit-profile"})
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getRequestURI().toString();
			if(url.contains("sign-up")) {
				request.getRequestDispatcher("/views/signUp.jsp").forward(request, response);
			}else if(url.contains("forgot-password")) {
				request.getRequestDispatcher("/views/forgotPass.jsp").forward(request, response);
			}else if(url.contains("change-password")) {
				request.getRequestDispatcher("/views/chagePassword.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/views/signIn.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String url = request.getRequestURI().toString();
			if(url.contains("sign-in")) {
				login(request, response);
			}else if(url.contains("sign-up")) {
				addUser(request, response);
			}else if(url.contains("forgot-password")) {
				forgotPass(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			UserDao dao = new UserDao();
			User user = dao.checkLogin(email, pass);
			if(user == null) {
				request.setAttribute("message", "Tài khoản không hợp lệ");
				request.getRequestDispatcher("/views/signIn.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String usID = request.getParameter("userId");
			String pass = request.getParameter("password");
			String name = request.getParameter("fullname");
			
			if(usID == null || usID.trim().isEmpty() ||
				pass==null || pass.trim().isEmpty() ||
				name == null || name.trim().isEmpty()) {
				
				request.setAttribute("validate", "Không được chừa ô trống nào");
				request.getRequestDispatcher("/views/signUp.jsp").forward(request, response);
			}else {
				User user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				
				UserDao dao = new UserDao();
				dao.create(user);
				request.setAttribute("message", "Thêm tài khoản thành công");
				request.getRequestDispatcher("/views/signIn.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	protected void forgotPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String mail = request.getParameter("email");
			
			
			if(mail == null || mail.trim().isEmpty()) {
				request.setAttribute("validateMail", "Mail không hợp lệ!");
				request.getRequestDispatcher("/views/forgotPass.jsp").forward(request, response);
				return;
			}
			
			UserDao dao = new UserDao();
			User user = dao.findByEmail(mail);
			if(user == null ) {
				request.setAttribute("validateMail", "Mail không tồn tại!");
				request.getRequestDispatcher("/views/forgotPass.jsp").forward(request, response);
			}else {
				JavaMailForgotPass mailForgot = new JavaMailForgotPass();
				mailForgot.JavaMailForgotPass(mail);
				
				request.setAttribute("message", "Mail đã được gửi, Vui lòng kiểm tra mail!");
				request.getRequestDispatcher("/views/signIn.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	
}
