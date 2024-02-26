package fpoly.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
	// Map lưu trữ thông tin về các trang
	public static Map<PageType, PageInfo> pageRoute = new HashMap();
	// Khởi tạo dữ liệu cho Map
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management","/admin/users/users.jsp",null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report Management","/admin/reports/reports.jsp",null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management","/admin/videos/videos.jsp",null));
		
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home page","/sites/home/home.jsp",null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login","/sites/users/login.jsp",null));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration","/sites/users/registration.jsp",null));
		pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password","/sites/users/change-password.jsp",null));
		pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile","/sites/users/edit-profile.jsp",null));
		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot password","/sites/users/forgot-pasword.jsp",null));
		pageRoute.put(PageType.SITE_DETAIL_VIDEO_PAGE, new PageInfo("Detail video","/sites/videos/detail.jsp",null));
		pageRoute.put(PageType.SITE_FAVORITE_VIDEO_PAGE, new PageInfo("Favorites video","/sites/videos/favorite.jsp",null));
		pageRoute.put(PageType.SITE_SHARE_VIDEO_PAGE, new PageInfo("Shares video","/sites/videos/share.jsp",null));
	}
	//Chuẩn bị và chuyển hướng đến trang
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		//dựa vào pageType được truyền vào, để lấy giá trị thông tin của pageRoute
		PageInfo page = pageRoute.get(pageType);
		
		// Đặt đối tượng PageInfo vào thuộc tính của yêu cầu
		request.setAttribute("page", page);
		// Chuyển hướng yêu cầu và phản hồi đến trang
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}
	

	//Chuẩn bị và chuyển hướng đến trang
	public static void prepareAndForwardSite(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		//dựa vào pageType được truyền vào, để lấy giá trị thông tin của pageRoute
		PageInfo page = pageRoute.get(pageType);
		
		// Đặt đối tượng PageInfo vào thuộc tính của yêu cầu
		request.setAttribute("page", page);
		// Chuyển hướng yêu cầu và phản hồi đến trang
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
	}
	// Các thuộc tính của đối tượng PageInfo
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	
	public PageInfo() {
	}
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
}
