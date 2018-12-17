package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
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
}
