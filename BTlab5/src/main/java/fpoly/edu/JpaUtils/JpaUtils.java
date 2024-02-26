package fpoly.edu.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
	public static EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("BTlab5").createEntityManager();
	}
}
