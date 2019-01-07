package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.TransactionDao;
import Model.Category;
import Model.LowCategory;

public class CategoryDao extends TransactionDao<Category> {
	protected CategoryDao() {
		super(Category.class);
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("Category.findAll", Category.class);
				return (List<Category>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	public Category getCategory(int idx) {
		return transaction((em) -> {
			try {
				String qy = "SELECT c FROM Category c WHERE c.idx = :idx";
				Query query = em.createQuery(qy);
				query.setParameter("idx", idx);
				return (Category) query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryList(LowCategory lowCategory) {
		return transaction((em) -> {
			try {
				String qy = "SELECT c FROM Category c WHERE c.lowCategory = :lowCategory";
				Query query = em.createQuery(qy);
				query.setParameter("lowCategory", lowCategory);
				return (List<Category>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
