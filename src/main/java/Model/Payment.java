package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tsn_payment")
@NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;

	@Column(name = "`COMMENT`")
	private String comment;

	private String contents;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private boolean isdeleted;

	private BigDecimal money;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateddate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOWCATEGORYCODE")
	private LowCategory lowCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYKEY")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATER")
	private User creater;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATER")
	private User updater;

	public Payment() {
	}

	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public BigDecimal getMoney() {
		return this.money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public LowCategory getLowCategory() {
		return this.lowCategory;
	}

	public void setLowCategory(LowCategory lowCategory) {
		this.lowCategory = lowCategory;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

}