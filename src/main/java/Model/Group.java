package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_group")
@NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g where g.isactive = true")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private boolean isactive;

	private boolean isdefault;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "map_action_role_group", joinColumns = { @JoinColumn(name = "GROUPCODE") }, inverseJoinColumns = { @JoinColumn(name = "ROLECODE") })
	private List<Actionrole> actionroles;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "map_view_role_group", joinColumns = { @JoinColumn(name = "GROUPCODE") }, inverseJoinColumns = { @JoinColumn(name = "VIEWCODE") })
	private List<Viewrole> viewroles;

	@ManyToMany(mappedBy="groups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users;

	public Group() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public boolean getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(boolean isdefault) {
		this.isdefault = isdefault;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Actionrole> getActionroles() {
		return this.actionroles;
	}

	public void setMstActionroles(List<Actionrole> actionroles) {
		this.actionroles = actionroles;
	}

	public List<Viewrole> getViewroles() {
		return this.viewroles;
	}

	public void setMstViewroles(List<Viewrole> viewroles) {
		this.viewroles = viewroles;
	}

	public List<User> geUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}