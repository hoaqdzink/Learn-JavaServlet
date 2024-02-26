package fpoly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import fpoly.edu.model.User;
import fpoly.edu.utils.JpaUtils;


public class UserDao {
	public void create(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(user);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public void update(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			em.merge(user);
			
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public void delete(String userId) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			User user = em.find(User.class, userId);
			if (user != null) {
				em.remove(user);
			}else {
				throw new Exception("User can not found");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public User findById(String userId) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			User user = em.find(User.class, userId);
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	
	public List<User> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			TypedQuery<User> query = em.createNamedQuery("User.findAll",User.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			em.close();
		}
		
	}
	
	public User checkLogin(String email, String password) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "select u from User u where u.email = :email and u.password = :password";
		
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		 try {
		        return query.getSingleResult();
		    } catch (NoResultException e) {
		        return null;
		    }
	}
	
	public User findByEmail(String email) {
		EntityManager em = JpaUtils.getEntityManager();

		String jqpl = "select u from User u where u.email = :email ";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);

		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // Trả về null nếu không tìm thấy kết quả
		}
	}
}
