package fpoly.edu.dao;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import fpoly.edu.model.User;

public class UserDAO {
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	public static List<User> listUser = new ArrayList();
	
	public List<User> dummyData() throws ParseException {
		listUser.add(new User("vinhnh","123asd","Nguyễn Hoàng Vinh",23,formatDate.parse("23/12/2001"), true));
		listUser.add(new User("khanhntk","123asd","Nguyễn Thị Kim Khánh",22,formatDate.parse("31/01/2001"), false));
		return listUser;
	}
	
	public List<User> getAll(){
		return listUser;
	}
	
	public void insert(User u) {
		listUser.add(u);
	}
	
	public int update(User u) {
		for (int i = 0; i< listUser.size(); i++) {
			if(listUser.get(i).getUsername().equals(u.getUsername())) {
				listUser.set(i, u);
				return i;
			}
		}
		return -1;
	}
	
	public User findByUsername(String username) {
		for(User user : listUser) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	public void save(User user) {
		if(findByUsername(user.getUsername()) != null) {
			update(user);
		}else {
			insert(user);
		}
	}
	public void delete(String username) {
		User u = findByUsername(username);
		if(u != null) {
			listUser.remove(u);
		}
	}
	
}
