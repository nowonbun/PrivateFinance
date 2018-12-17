package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Model.Localization;

public class LocalizationDao extends MasterDao<Localization> {
	protected LocalizationDao() {
		super(Localization.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Localization> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("Localization.findAll", Localization.class);
				return (List<Localization>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
