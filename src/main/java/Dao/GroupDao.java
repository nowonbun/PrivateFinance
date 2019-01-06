package Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import Common.MasterDao;
import Model.Group;

public class GroupDao extends MasterDao<Group> {
	protected GroupDao() {
		super(Group.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Group> getDataList() {
		return transaction((em) -> {
			try {
				Query query = em.createNamedQuery("Group.findAll", Group.class);
				return (List<Group>) query.getResultList();
			} catch (NoResultException e) {
				return null;
			}
		});
	}

	public Group getGroup(String code) {
		Optional<Group> ret = getData().stream().filter(x -> x.getCode().equals(code)).findFirst();
		if (!ret.isPresent()) {
			return null;
		} else {
			return ret.get();
		}
	}
}
