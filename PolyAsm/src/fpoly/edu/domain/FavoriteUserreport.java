package fpoly.edu.domain;

import java.util.Date;

public class FavoriteUserreport {
	private String username;
	private String fullname;
	private String email;
	private Date likeDate;
	
	public FavoriteUserreport() {
	}
	public FavoriteUserreport(String username, String fullname, String email, Date likeDate) {
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.likeDate = likeDate;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
}
