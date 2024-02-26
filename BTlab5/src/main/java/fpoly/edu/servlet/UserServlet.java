package fpoly.edu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpoly.edu.dao.UserDao;
import fpoly.edu.model.User;


@WebServlet({"/UserServlet","/UserServlet/create","/UserServlet/update",
			"/UserServlet/delete","/UserServlet/reset","/UserServlet/edit"})
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		
		if(url.contains("delete")) {
			delete(request, response);
			User user = null;
			user = new User();
			request.setAttribute("user", user);
		}else if(url.contains("edit")) {
			User user = null;
			edit(request, response);
		}else if(url.contains("reset")) {
			User user = null;
			user = new User();
			request.setAttribute("user", user);
		}
		
		findAll(request, response);
		request.getRequestDispatcher("/views/formUsers.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("UTF-8");
		if(url.contains("create")) {
			insert(request, response);
		}else if(url.contains("update")) {
			update(request, response);
		}else if(url.contains("reset")) {
			request.setAttribute("user", new User());
		}else if(url.contains("delete")) {
			delete(request, response);
			request.setAttribute("user",  new User());
		}
		User user = new User();
		findAll(request, response);
		request.getRequestDispatcher("/views/formUsers.jsp").forward(request, response);
	}
	
	// chức năng thêm	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDao dao = new UserDao();
			dao.insertUser(user);
			request.setAttribute("message", "User inserted!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		request.getRequestDispatcher("/views/formUsers.jsp").forward(request, response);
	}
	//chức năng sửa
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDao dao = new UserDao();
			dao.updateUser(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "User updated!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	//chức năng xóa
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userId = request.getParameter("userId");
			
			UserDao dao = new UserDao();
			dao.delete(userId);
			
			request.setAttribute("message", "User delete!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	// chức năng edit	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userId = request.getParameter("userId");
			
			UserDao dao = new UserDao();
			User user =  dao.findById(userId);
			
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	// Chức năng hiểm thị dữ liệu lên bảng
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();
			
			List<User> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
