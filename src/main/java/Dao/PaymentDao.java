package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.TransactionDao;
import Model.LowCategory;
import Model.Payment;

public class PaymentDao extends TransactionDao<Payment> {
	protected PaymentDao() {
		super(Payment.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> getDataByYearMonth(int year, int month){
		return transaction((em) -> {
			try {
				String qy = "SELECT p FROM Payment p "
						+ "WHERE FUNC('YEAR',p.date) = :year and FUNC('MONTH',p.date) = :month and p.isdeleted = false "
						+ "ORDER BY p.date asc";
				Query query = em.createQuery(qy);
				query.setParameter("year", year);
				query.setParameter("month", month);
				return (List<Payment>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
	
	public Payment getDataByIdx(int idx){
		return transaction((em) -> {
			try {
				String qy = "SELECT p FROM Payment p "
						+ "WHERE p.idx =:idx ";
				Query query = em.createQuery(qy);
				query.setParameter("idx", idx);
				return (Payment) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
	
	public Number getFullTotal(LowCategory lc) {
		return transaction((em) -> {
			try {
				String qy = "SELECT SUM(p.money) FROM Payment p "
						+ "WHERE p.lowCategory = :lc and p.isdeleted = false";
				Query query = em.createQuery(qy);
				query.setParameter("lc", lc);
				Number ret = (Number) query.getSingleResult();
				if(ret == null) {
					return 0;
				}
				return ret;
			} catch (NoResultException e) {
				return 0;
			}
		});
	}
}
