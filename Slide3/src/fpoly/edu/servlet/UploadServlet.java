package fpoly.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			
			//Xử lý tải image lên
			Part part = request.getPart("image");
			
			//Xác định Đường dẫn Tệp:
			//Lấy đường dẫn thực tế của thư mục "/images" trong ngữ cảnh servlet.
			//Đây là thư mục nơi hình ảnh tải lên sẽ được lưu trữ trên máy chủ.
			String realPath = request.getServletContext().getRealPath("/images");
			//Xác định đường dẫn lưu cụ thể
			//String uploadDirectory = "E:\\Java_Space\\slide3demo\\WebContent\\images";
			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			//Tạo Thư mục Nếu Không Tồn Tại:
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectory(Path.of(realPath));
			}
			//Ghi tệp
			part.write(realPath + "/" + filename);
			
			try(PrintWriter out = response.getWriter()){
				out.println("<h1> Name: "+ name+"</h1>");
				out.println("<img src='./images/" + filename + "' width='80' height='80' />");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
