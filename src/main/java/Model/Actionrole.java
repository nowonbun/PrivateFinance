package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="mst_actionrole")
@NamedQuery(name="Actionrole.findAll", query="SELECT a FROM Actionrole a where a.isactive = true")
public class Actionrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private boolean isactive;

	private String name;

	@ManyToMany(mappedBy="actionroles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Group> groups;

	@ManyToMany(mappedBy="actionroles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users;

	public Actionrole() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}