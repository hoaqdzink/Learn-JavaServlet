package fpoly.edu.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import fpoly.edu.model.Staff;
@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/ReadInformationForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtc, Date.class);
			
			Staff staff = new Staff();
			BeanUtils.populate(staff, request.getParameterMap());
			String url = "E:\\JavaServlet\\BTlab3\\WebContent\\views\\upload";
			Path uploadPath = Paths.get(url);
			
			if(!Files.exists(uploadPath)) {
				Files.createDirectory(uploadPath);
			}
			Part imagePart = request.getPart("imageName");
			
			String imageFilename = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
			
			imagePart.write(Paths.get(uploadPath.toString(), imageFilename).toString());
			staff.setImageName(imageFilename);
			
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/views/ReadInformationForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
