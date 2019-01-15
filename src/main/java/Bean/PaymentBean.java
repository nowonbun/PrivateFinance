package Bean;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentBean {
	private int idx;
	private Date date;
	private String day;
	private String type_code;
	private String type_disp;
	private String category_code;
	private String category_disp;
	private String contents;
	private BigDecimal money;
	private String money_disp;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType_code() {
		return type_code;
	}

	public void setType_code(String type_code) {
		this.type_code = type_code;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getType_disp() {
		return type_disp;
	}

	public void setType_disp(String type_disp) {
		this.type_disp = type_disp;
	}

	public String getCategory_disp() {
		return category_disp;
	}

	public void setCategory_disp(String category_disp) {
		this.category_disp = category_disp;
	}

	public String getMoney_disp() {
		return money_disp;
	}

	public void setMoney_disp(String money_disp) {
		this.money_disp = money_disp;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
