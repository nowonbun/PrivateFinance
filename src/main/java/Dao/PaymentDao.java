package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.TransactionDao;
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
						+ "WHERE FUNC('YEAR',p.date) = :year and FUNC('MONTH',p.date) = :month and p.isdeleted = false";
				Query query = em.createQuery(qy);
				query.setParameter("year", year);
				query.setParameter("month", month);
				return (List<Payment>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
