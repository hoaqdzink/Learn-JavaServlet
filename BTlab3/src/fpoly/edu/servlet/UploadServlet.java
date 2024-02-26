package fpoly.edu.servlet;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
		RequestDispatcher rd = request.getRequestDispatcher("/views/upload.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = "E:\\JavaServlet\\BTlab3\\WebContent\\views\\upload";
			Path uploadPath = Paths.get(url);
			
			if(!Files.exists(Paths.get(url))) {
				Files.createDirectory(uploadPath);
			}
			
			//Xử lý tải image lên
			Part imagePart = request.getPart("image");
			//xử lý tải tài liệu
			Part documentPart = request.getPart("document");
			
			// part.getSubmittedFileName() ấy tên của tệp tin mà người dùng đã tải lên thông qua form
			// Path.of(part.getSubmittedFileName()) Tạo một đối tượng Path từ tên tệp tin được trả về ở bước trước. 
			//Đối tượng Path được sử dụng để thực hiện các thao tác liên quan đến đường dẫn trên hệ thống tệp tin.
			//getFileName(): Lấy ra phần tên của đối tượng Path.
			//toString(): Chuyển đối tượng tên tệp tin thành một chuỗi.
			String imageFilename = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
			String documentFilename = Path.of(documentPart.getSubmittedFileName()).getFileName().toString();
			
			imagePart.write(Paths.get(uploadPath.toString(), imageFilename).toString());
			documentPart.write(Paths.get(uploadPath.toString(), documentFilename).toString());
			
			request.setAttribute("image", imageFilename);
			request.setAttribute("document", documentFilename);
			
			request.getRequestDispatcher("/views/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
