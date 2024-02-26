package fpoly.edu.common;

import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	//lấy dữ liệu từ cookie truyền vào http
	// Phương thức nhận vào tên của cookie và đối tượng HttpServletRequest
	public static String get(String name, HttpServletRequest request) {
	    // Lấy danh sách tất cả các cookies từ yêu cầu
	    Cookie[] cookies = request.getCookies();
	    
	    // Kiểm tra xem có cookies nào không
	    if (cookies != null) {
	        // Duyệt qua từng cookie trong danh sách
	        for (Cookie cookie : cookies) {
	            // So sánh tên của cookie với tên được truyền vào
	            if (cookie.getName().equalsIgnoreCase(name)) {
	                // Nếu tìm thấy cookie có tên giống, trả về giá trị của cookie đó
	                return cookie.getValue();
	            }
	        }
	    }
	    // Nếu không tìm thấy cookie có tên giống, trả về chuỗi rỗng
	    return "";
	}
	
	
	// Phương thức nhận vào tên cookie, giá trị, thời gian sống (tính bằng giờ), và đối tượng HttpServletResponse
	public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
	    // Tạo một đối tượng Cookie với tên và giá trị được cung cấp
	    Cookie cookie = new Cookie(name, value);
	    
	    // Đặt thời gian sống cho cookie (tính bằng giờ)
	    cookie.setMaxAge(60 * 60 * hours);
	    
	    // Đặt đường dẫn của cookie (ở đây là "/"), có nghĩa là cookie có thể được truy cập từ mọi đường dẫn trong trang web
	    cookie.setPath("/");
	    
	    // Thêm cookie vào phản hồi để nó được gửi đến máy khách
	    response.addCookie(cookie);
	    
	    // Trả về đối tượng Cookie đã tạo
	    return cookie;
	}
}
