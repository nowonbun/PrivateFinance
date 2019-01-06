package Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Common.Util;
import Model.Actionrole;
import Model.Viewrole;

public class ActionroleDao extends MasterDao<Actionrole> {
	protected ActionroleDao() {
		super(Actionrole.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Actionrole> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("Actionrole.findAll", Actionrole.class);
				return (List<Actionrole>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	public Actionrole getRole(String code) {
		Optional<Actionrole> data = super.getData().stream().filter(x -> Util.StringEquals(x.getCode(), code)).findFirst();
		if (!data.isPresent()) {
			return null;
		} else {
			return data.get();
		}
	}
}
