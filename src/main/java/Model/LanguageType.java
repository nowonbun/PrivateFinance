package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_language_type")
@NamedQuery(name = "LanguageType.findAll", query = "SELECT l FROM LanguageType l where l.isactive = true")
public class LanguageType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private boolean isactive;

	private String name;

	@OneToMany(mappedBy = "languaueType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Localization> localizations;

	@OneToMany(mappedBy = "languaueType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users;

	public LanguageType() {
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

	public List<Localization> getLocalizations() {
		return this.localizations;
	}

	public void setLocalizations(List<Localization> localizations) {
		this.localizations = localizations;
	}

	public Localization addLocalization(Localization localizations) {
		getLocalizations().add(localizations);
		localizations.setLanguaueType(this);

		return localizations;
	}

	public Localization removeLocalization(Localization localizations) {
		getLocalizations().remove(localizations);
		localizations.setLanguaueType(null);

		return localizations;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setLanguaueType(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setLanguaueType(null);

		return user;
	}

}