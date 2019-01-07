package Dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Model.LanguageType;

public class LanguageTypeDao extends MasterDao<LanguageType> {
	protected LanguageTypeDao() {
		super(LanguageType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<LanguageType> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("LanguageType.findAll", LanguageType.class);
				return (List<LanguageType>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
	
	public LanguageType getLanuageType(String code) {
		Optional<LanguageType> ret = getData().stream().filter(x -> x.getCode().equals(code)).findFirst();
		if (!ret.isPresent()) {
			return null;
		} else {
			return ret.get();
		}
	}
}
