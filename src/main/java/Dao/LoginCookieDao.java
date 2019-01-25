package Dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.TransactionDao;
import Model.LoginCookie;
import Model.User;

public class LoginCookieDao extends TransactionDao<LoginCookie> {
	protected LoginCookieDao() {
		super(LoginCookie.class);
	}

	public LoginCookie getLoginCookieByUser(User user) {
		return transaction((em) -> {
			try {
				String qy = "SELECT l FROM LoginCookie l WHERE  l.user = :user and l.isdeleted = false";
				Query query = em.createQuery(qy);
				query.setParameter("user", user);
				return (LoginCookie) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	public LoginCookie getLoginCookieByKey(String cookiekey) {
		return transaction((em) -> {
			try {
				String qy = "SELECT l FROM LoginCookie l WHERE  l.cookiekey = :cookiekey and l.isdeleted = false";
				Query query = em.createQuery(qy);
				query.setParameter("cookiekey", cookiekey);
				return (LoginCookie) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	public int clearLoginCookie(User user) {
		return transaction((em) -> {
			try {
				String qy = "UPDATE LoginCookie SET isdeleted=true WHERE user = :user";
				Query query = em.createQuery(qy);
				query.setParameter("user", user);
				return query.executeUpdate();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
