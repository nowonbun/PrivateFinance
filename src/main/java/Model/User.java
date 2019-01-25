package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tsn_user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	private String email;

	private boolean isdeleted;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "map_user_group", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "CODE") })
	private List<Group> groups;

	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Payment> createrPayments;

	@OneToMany(mappedBy = "updater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Payment> updaterPayments;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "map_action_role_user", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLECODE") })
	private List<Actionrole> actionroles;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY")
	private LanguageType languaueType;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "map_view_role_user", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "VIEWCODE") })
	private List<Viewrole> viewroles;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LoginCookie> loginCookies;
	
	@OneToMany(mappedBy = "creater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Category> createrCategories;

	@OneToMany(mappedBy = "updater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Category> updaterCategories;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean Isdeleted() {
		return this.isdeleted;
	}

	public void setdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
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

	public List<Payment> getCreaterPayments() {
		return this.createrPayments;
	}

	public void setCreaterPayments(List<Payment> createrPayments) {
		this.createrPayments = createrPayments;
	}

	public Payment addCreaterPayments(Payment createrPayment) {
		getCreaterPayments().add(createrPayment);
		createrPayment.setCreater(this);

		return createrPayment;
	}

	public Payment removeCreaterPayments(Payment createrPayment) {
		getCreaterPayments().remove(createrPayment);
		createrPayment.setCreater(null);

		return createrPayment;
	}

	public List<Payment> getUpdaterPayments() {
		return this.updaterPayments;
	}

	public void setUpdaterPayments(List<Payment> updaterPayments) {
		this.updaterPayments = updaterPayments;
	}

	public Payment addUpdaterPayments(Payment updaterPayment) {
		getUpdaterPayments().add(updaterPayment);
		updaterPayment.setUpdater(this);

		return updaterPayment;
	}

	public Payment removeUpdaterPayments(Payment updaterPayment) {
		getUpdaterPayments().remove(updaterPayment);
		updaterPayment.setUpdater(null);

		return updaterPayment;
	}

	public List<Actionrole> getActionroles() {
		return this.actionroles;
	}

	public void setMstActionroles(List<Actionrole> actionroles) {
		this.actionroles = actionroles;
	}

	public LanguageType getLanguaueType() {
		return this.languaueType;
	}

	public void setLanguaueType(LanguageType languaueType) {
		this.languaueType = languaueType;
	}

	public List<Viewrole> getViewroles() {
		return this.viewroles;
	}

	public void setViewroles(List<Viewrole> viewroles) {
		this.viewroles = viewroles;
	}
	
	public List<LoginCookie> getLoginCookies() {
		return this.loginCookies;
	}

	public void setLoginCookies(List<LoginCookie> loginCookies) {
		this.loginCookies = loginCookies;
	}

	public LoginCookie addLoginCooky(LoginCookie loginCookie) {
		getLoginCookies().add(loginCookie);
		loginCookie.setUser(this);

		return loginCookie;
	}

	public LoginCookie removeLoginCooky(LoginCookie loginCookie) {
		getLoginCookies().remove(loginCookie);
		loginCookie.setUser(null);

		return loginCookie;
	}
	public List<Category> getUpdaterCategories() {
		return this.updaterCategories;
	}

	public void setUpdaterCategories(List<Category> updaterCategories) {
		this.updaterCategories = updaterCategories;
	}

	public Category addUpdaterCategory(Category updaterCategory) {
		getUpdaterCategories().add(updaterCategory);
		updaterCategory.setUpdater(this);

		return updaterCategory;
	}

	public Category removeUpdaterCategory(Category updaterCategory) {
		getUpdaterCategories().remove(updaterCategory);
		updaterCategory.setUpdater(null);

		return updaterCategory;
	}
	public List<Category> getCreaterCategories() {
		return this.createrCategories;
	}

	public void setCreaterCategories(List<Category> createrCategories) {
		this.createrCategories = createrCategories;
	}

	public Category addCreaterCategory(Category createrCategories) {
		getCreaterCategories().add(createrCategories);
		createrCategories.setUpdater(this);

		return createrCategories;
	}

	public Category removeCreaterCategory(Category createrCategories) {
		getCreaterCategories().remove(createrCategories);
		createrCategories.setUpdater(null);

		return createrCategories;
	}
}