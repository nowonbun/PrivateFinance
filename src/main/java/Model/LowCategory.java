package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_low_category")
@NamedQuery(name = "LowCategory.findAll", query = "SELECT l FROM LowCategory l where l.isactive = true")
public class LowCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private boolean isactive;

	private String name;

	@OneToMany(mappedBy = "lowCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Category> categories;

	@OneToMany(mappedBy = "lowCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Payment> payments;

	public LowCategory() {
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

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addTsnCategory(Category category) {
		getCategories().add(category);
		category.setMstLowCategory(this);

		return category;
	}

	public Category removeTsnCategory(Category category) {
		getCategories().remove(category);
		category.setMstLowCategory(null);

		return category;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setTsnPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addTsnPayment(Payment payment) {
		getPayments().add(payment);
		payment.setLowCategory(this);

		return payment;
	}

	public Payment removeTsnPayment(Payment payment) {
		getPayments().remove(payment);
		payment.setLowCategory(null);

		return payment;
	}

}