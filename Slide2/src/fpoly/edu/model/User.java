package fpoly.edu.model;

public class User {
	private String username;
	private String password;
	
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkLogin(String users, String passW) {
		if(users.equals("admin") && passW.equals("123")) {
			return true;
		}
		return false;
	}
	
}
