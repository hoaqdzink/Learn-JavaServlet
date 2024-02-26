package fpoly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpoly.edu.helpers.JpaUtils;
import fpoly.edu.model.Report;
import fpoly.edu.model.Video;

public class VideoDao {
	public List<Video> findFavoriteVideoByKeyword(String keyword){
		String jpql ="SELECT DISTINCT f.video FROM Favourite f WHERE f.video.title LIKE :keyword";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		
		query.setParameter("keyword", "%" + keyword + "%");
		
		return query.getResultList();
	}
	public List<Video> findVideoByFavorite(boolean isFavorite){
		String jpql;
		
		if(isFavorite) {
			jpql = "SELECT DISTINCT v FROM Video v WHERE v.favourites IS NOT EMPTY";
		}else {
			jpql = "SELECT DISTINCT v FROM Video v WHERE v.favourites IS EMPTY";
		}
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		
		
		return query.getResultList();
	}
	public List<Report> report(){
		String jpql = " SELECT new fpoly.edu.model.Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate))" +
						" From Favourite f GROUP BY f.video.title";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Report> query = em.createQuery(jpql,Report.class);
		
		return query.getResultList();
	}
	
}
