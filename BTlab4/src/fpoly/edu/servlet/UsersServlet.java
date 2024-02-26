package fpoly.edu.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import fpoly.edu.dao.UserDAO;
import fpoly.edu.model.User;


@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		User user = null;
		String action = request.getParameter("action");
		
		try {
			if(action == null || action.equals("")) {
				request.setAttribute("LIST_USER", dao.dummyData());
				request.getRequestDispatcher("/views/register/_listUser.jsp").forward(request, response);
				return;
			}
			
			switch (action) {
				case "AddOrEdit": {
					String username = request.getParameter("username");
					user = dao.findByUsername(username);
					if(user == null) {
						user = new User();
					}
					request.setAttribute("USER", user);
					request.getRequestDispatcher("/views/register/_dangKy.jsp").forward(request, response);					
					break;
				}
				case "List":{
					request.setAttribute("LIST_USER", dao.getAll());
					request.getRequestDispatcher("/views/register/_listUser.jsp").forward(request, response);	
					break;
				}
				case "Delete":{
					String username = request.getParameter("username");
					if(dao.findByUsername(username) != null) {
						dao.delete(username);
					}
					request.setAttribute("LIST_USER", dao.getAll());
					request.getRequestDispatcher("/views/register/_listUser.jsp").forward(request, response);	
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			UserDAO dao = new UserDAO();
			User user = null;
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtc, Date.class);
			user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			dao.save(user);
			request.getRequestDispatcher("/views/register/_dangKy.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
