package fpoly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpoly.edu.domain.FavoriteReport;
import fpoly.edu.domain.FavoriteUserreport;
import fpoly.edu.model.Favorite;

public class FavoriteDao extends EntityDao<Favorite> {
	public FavoriteDao() {
		super(Favorite.class);
	}
	
	public List<FavoriteReport>  reportFavoritesByVideos(){
		String jpql = "SELECT  new fpoly.edu.domain.FavoriteReport(f.video.title, count(f), MIN(f.likedDate), MAX(f.likedDate))"
				+ "from Favorite f group by f.video.title";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return list;
	}
	
	public List<FavoriteUserreport> reportFavoriteUsersByVideo(String videoId){
		String jpql = "SELECT new fpoly.edu.domain.FavoriteUserreport(f.user.username, f.user.fullname, f.user.email, f.likedDate)"
				+ " FROM Favorite f WHERE f.video.videoId = :videoId ";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteUserreport> list = null;
		
		try {
			TypedQuery<FavoriteUserreport> query = em.createQuery(jpql, FavoriteUserreport.class);
			query.setParameter("videoId", videoId);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		return list;
	}
}
