package fpoly.edu.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	//lấy dữ liệu từ cookie truyền vào HTTP
	public static String get(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return "";
	}
	//Lưu cookie
	public static Cookie add(String name, String value, int hours, HttpServletResponse respone) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * hours);
		cookie.setPath("/");
		respone.addCookie(cookie);
		
		return cookie;
	}
}
