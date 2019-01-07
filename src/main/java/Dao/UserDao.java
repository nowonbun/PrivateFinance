package Dao;

import java.util.List;

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
				String qy = "SELECT u FROM User u WHERE u.id = :id";
				Query query = em.createQuery(qy);
				query.setParameter("id", id);
				return (User) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserAll() {
		return transaction((em) -> {
			try {
				String qy = "SELECT u FROM User u";
				Query query = em.createQuery(qy);
				return (List<User>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserLikeEmail(String email) {
		return transaction((em) -> {
			try {
				String qy = "SELECT u FROM User u where u.email like CONCAT('%',:email,'%')";
				Query query = em.createQuery(qy);
				query.setParameter("email", email);
				return (List<User>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
