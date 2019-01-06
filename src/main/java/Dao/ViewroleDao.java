package Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Common.Util;
import Model.Viewrole;

public class ViewroleDao extends MasterDao<Viewrole> {
	protected ViewroleDao() {
		super(Viewrole.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Viewrole> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("Viewrole.findAll", Viewrole.class);
				return (List<Viewrole>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	public Viewrole getRole(String code) {
		Optional<Viewrole> data = super.getData().stream().filter(x -> Util.StringEquals(x.getCode(), code)).findFirst();
		if (!data.isPresent()) {
			return null;
		} else {
			return data.get();
		}
	}
}
