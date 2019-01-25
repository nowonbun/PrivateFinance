package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tsn_category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;

	private boolean isdeleted;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOWCATEGORYCODE")
	private LowCategory lowCategory;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Payment> payments;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateddate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATER")
	private User creater;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATER")
	private User updater;

	public Category() {
	}

	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public boolean getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LowCategory getMstLowCategory() {
		return this.lowCategory;
	}

	public void setMstLowCategory(LowCategory lowCategory) {
		this.lowCategory = lowCategory;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addTsnPayment(Payment payment) {
		getPayments().add(payment);
		payment.setCategory(this);

		return payment;
	}

	public Payment removeTsnPayment(Payment payment) {
		getPayments().remove(payment);
		payment.setCategory(null);

		return payment;
	}

	public User getCreater() {
		return this.creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public User getUpdater() {
		return this.updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
}