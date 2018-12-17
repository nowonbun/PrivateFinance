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

	private boolean isdelted;

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

	public boolean getIsdelted() {
		return this.isdelted;
	}

	public void setIsdelted(boolean isdelted) {
		this.isdelted = isdelted;
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

	public Payment removeTsnPayments1(Payment createrPayment) {
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

	public Payment addTsnPayments2(Payment updaterPayment) {
		getUpdaterPayments().add(updaterPayment);
		updaterPayment.setUpdater(this);

		return updaterPayment;
	}

	public Payment removeTsnPayments2(Payment updaterPayment) {
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

}