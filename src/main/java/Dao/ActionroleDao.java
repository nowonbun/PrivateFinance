package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Model.Actionrole;

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
}
