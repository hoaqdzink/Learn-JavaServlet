package fpoly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpoly.edu.helpers.JpaUtils;
import fpoly.edu.model.Favourite;
import fpoly.edu.model.User;
import jakarta.persistence.Query;

public class UserDao {
	public User findById(String userId) {
		EntityManager em = JpaUtils.getEntityManager();
		
		var user = em.find(User.class, userId);
		if(user != null) {
			List<Favourite> list = user.getFavourites();
			list.forEach(item ->item.getVideo());
		}
		
		return user;
	}
	
	public List<User> findUserByFavorite(String videoId){
		String jpql ="SELECT DISTINCT f.user FROM Favourite f WHERE f.video.id = :videoId";
		EntityManager em = JpaUtils.getEntityManager();
		
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("videoId",videoId);
		
		return query.getResultList();
	}
}
