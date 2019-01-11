package Dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Common.Util;
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

	public String getLocalization(String name, String type) {
		Optional<Localization> data = super.getData().stream().filter(x -> Util.StringEqualsUpper(x.getId().getKey(), name) && Util.StringEqualsUpper(x.getId().getType(), type)).findFirst();
		if (!data.isPresent()) {
			return name;
		} else {
			return data.get().getValue();
		}
	}
}
