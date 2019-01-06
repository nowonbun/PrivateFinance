package Bean;

import java.util.List;

public class RoleListBean {
	private boolean isSearch;
	private List<RoleBean> beanlist;

	public boolean isSearch() {
		return isSearch;
	}

	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}

	public List<RoleBean> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(List<RoleBean> beanlist) {
		this.beanlist = beanlist;
	}

}
