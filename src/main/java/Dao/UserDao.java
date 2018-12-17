package Dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.TransactionDao;
import Model.User;

public class UserDao extends TransactionDao<User> {
	protected UserDao() {
		super(User.class);
	}

	public User getUser(String id) {
		return transaction((em) -> {
			try {
				String qy = "SELECT u FROM User u WHERE u.id = :id and u.isdelted = false";
				Query query = em.createQuery(qy);
				query.setParameter("id", id);
				return (User) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
