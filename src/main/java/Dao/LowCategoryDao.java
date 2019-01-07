package Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Common.Util;
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

	public LowCategory getLowCategory(String code) {
		Optional<LowCategory> data = super.getData().stream().filter(x -> Util.StringEquals(x.getCode(), code)).findFirst();
		if (!data.isPresent()) {
			return null;
		} else {
			return data.get();
		}
	}
}
