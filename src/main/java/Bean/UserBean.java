package Bean;

import java.util.List;

public class UserBean {
	private String id;
	private String email;
	private String name;
	private String country;
	private List<String> group;
	private boolean deleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<String> getGroup() {
		return group;
	}

	public void setGroup(List<String> group) {
		this.group = group;
	}

}
