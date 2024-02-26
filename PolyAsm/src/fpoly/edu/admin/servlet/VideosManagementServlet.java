package fpoly.edu.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpoly.edu.common.PageInfo;
import fpoly.edu.common.PageType;
import fpoly.edu.common.UploadUtils;
import fpoly.edu.dao.VideoDao;
import fpoly.edu.model.Video;


@WebServlet({"/Admin/VideosManagement","/Admin/VideosManagement/create","/Admin/VideosManagement/update",
	"/Admin/VideosManagement/delete","/Admin/VideosManagement/reset","/Admin/VideosManagement/edit"})
@MultipartConfig
public class VideosManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("edit")) {
			edit(request, response);
			return;
		}else if(url.contains("delete")) {
			delete(request, response);
			return;
		}else if(url.contains("reset")) {
			reset(request, response);
			return;
		}
		Video video = new Video();
		video.setPoster("images/Desktop.png");
		findAll(request,response);
		request.setAttribute("video", video);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if(url.contains("create")) {
			create(request, response);
			return;
		}else if(url.contains("delete")) {
			delete(request, response);
			return;
		}else if(url.contains("update")) {
			update(request, response);
			return;
		}else if(url.contains("reset")) {
			reset(request, response);
			return;
		}
		
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	
	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video video = new Video();
		video.setPoster("Desktop.png");
		request.setAttribute("video", video);
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video video = new Video();
		
		try {
			BeanUtils.populate(video, request.getParameterMap());
			
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findById(video.getVideoId());
			
			if(request.getPart("cover").getSize()==0) {
				video.setPoster(oldVideo.getPoster());
			}else {
				video.setPoster("videos/" + UploadUtils.processUploadFile("cover", request, "/videos", video.getVideoId()));
			}
			
			dao.update(video);
			
			request.setAttribute("video", video);
			request.setAttribute("message", "Video is updated!");
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error","Error: " + e.getMessage());
			findAll(request,response);
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("videoId");
		
		if (id == null) {
			request.setAttribute("error", "Video id is required");
			PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			
			if (video == null) {
				request.setAttribute("error", "Video id not found");
				findAll(request, response);
				PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
				return;
			}
			
			dao.delete(id);
			
			request.setAttribute("message", "Video is deleted!");
			request.setAttribute("video", new Video());
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error","Error: " + e.getMessage());
		}
		
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();
			
			request.setAttribute("videos", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error","Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		
		if (id == null) {
			request.setAttribute("error", "Video id is required");
			PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}
		
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			
			request.setAttribute("video", video);
			
			findAll(request,response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error","Error: " + e.getMessage());
		}
		
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			video.setPoster("videos/" + UploadUtils.processUploadFile("cover", request, "/videos", video.getVideoId()));
			
			VideoDao dao = new VideoDao();
			dao.insert(video);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video is inserted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		findAll(request,response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}
}
