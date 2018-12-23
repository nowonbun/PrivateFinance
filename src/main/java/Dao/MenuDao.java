package Dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Model.Menu;

public class MenuDao extends MasterDao<Menu> {
	protected MenuDao() {
		super(Menu.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Menu> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("Menu.findAll", Menu.class);
				return (List<Menu>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}
}
