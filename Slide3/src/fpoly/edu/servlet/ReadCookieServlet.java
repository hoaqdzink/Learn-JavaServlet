package fpoly.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadCookieServlet")
public class ReadCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khai báo mảng cookie 
		//lấy danh sách các cookie
		Cookie[] cookies = request.getCookies();
		try(PrintWriter out = response.getWriter()){
			//nếu danh sách cookie không trống
			if(cookies !=null) {
				for(int i =0; i< cookies.length;i++) {
					Cookie cookie = cookies[i];
					out.println("Name: " + cookie.getName() + " value: " + cookie.getValue());
				}
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
