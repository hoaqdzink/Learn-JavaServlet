package fpoly.edu.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtils {
	public static String processUploadFile(String filename, HttpServletRequest request, String storedFolder, String storedFilename) throws IOException, ServletException {
		
		// Lấy đối tượng Part từ request, đại diện cho trường file trong form HTML.
		Part filePart = request.getPart(filename);
		
		// Kiểm tra xem trường file có tồn tại và có kích thước lớn hơn 0 không.
		if(filePart == null || filePart.getSize() == 0) {
			return ""; // Trường file không tồn tại hoặc kích thước là 0, trả về chuỗi rỗng.
		}
		
		// Kiểm tra và sử dụng thư mục lưu trữ mặc định nếu không được chỉ định.
		if (storedFolder == null) {
			storedFolder = "/videos";
		}
		 // Xử lý tên file lưu trữ trên server.
		if (storedFilename == null) {
			storedFilename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		}else {
			 // Nếu tên file lưu trữ đã được chỉ định, thêm phần mở rộng của file gốc.
			//FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString()); lấy đui của file
			storedFilename += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}
		
		
		// Lấy đường dẫn thực tế của thư mục lưu trữ trên server.
		String uploadFolder = "E:\\JavaServlet\\PolyAsm\\WebContent\\images\\videos";
		
		// Tạo đối tượng Path đại diện cho đường dẫn lưu trữ trên.
        Path uploadPath = Paths.get(uploadFolder);
        // Kiểm tra xem thư mục lưu trữ có tồn tại hay không. Nếu không, tạo mới.
        if (!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}
        // Ghi file vào thư mục lưu trữ.
		filePart.write(Paths.get(uploadPath.toString(), storedFilename).toString());
		// Trả về tên file đã được lưu trữ trên server.
		return storedFilename;
	}
}
