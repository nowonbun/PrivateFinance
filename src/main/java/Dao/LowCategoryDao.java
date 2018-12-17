package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Model.LowCategory;

public class LowCategoryDao extends MasterDao<LowCategory> {
	protected LowCategoryDao() {
		super(LowCategory.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<LowCategory> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("LowCategory.findAll", LowCategory.class);
				return (List<LowCategory>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
