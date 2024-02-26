package fpoly.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fpoly.edu.model.User;

public class UserDao extends EntityDao<User> {

	public UserDao() {
		super(User.class);
	}
	
	public void changePassword(String username, String password, String newPassword) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		String jpql = "SELECT u FROM User u WHERE u.username = :username and u.password = :password";
		
		try {
			trans.begin();
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			User user = query.getSingleResult();
			if (user == null) {
				throw new Exception("Current password or Username are incorrect");
			}
			user.setPassword(newPassword);
			em.merge(user);
			trans.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
}
