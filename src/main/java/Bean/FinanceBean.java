package Bean;

import java.util.List;

public class FinanceBean {
	private String incomeTotal;
	private String expenditureTotal;
	private int savingsign;
	private String savingTotal;
	private int financesign;
	private String financeTotal;
	private List<PaymentBean> financelist;
	private List<PaymentBean> savinglist;

	public String getIncomeTotal() {
		return incomeTotal;
	}

	public void setIncomeTotal(String incomeTotal) {
		this.incomeTotal = incomeTotal;
	}

	public String getExpenditureTotal() {
		return expenditureTotal;
	}

	public void setExpenditureTotal(String expenditureTotal) {
		this.expenditureTotal = expenditureTotal;
	}

	public String getSavingTotal() {
		return savingTotal;
	}

	public void setSavingTotal(String savingTotal) {
		this.savingTotal = savingTotal;
	}

	public String getFinanceTotal() {
		return financeTotal;
	}

	public void setFinanceTotal(String financeTotal) {
		this.financeTotal = financeTotal;
	}

	public List<PaymentBean> getFinancelist() {
		return financelist;
	}

	public void setFinancelist(List<PaymentBean> financelist) {
		this.financelist = financelist;
	}

	public List<PaymentBean> getSavinglist() {
		return savinglist;
	}

	public void setSavinglist(List<PaymentBean> savinglist) {
		this.savinglist = savinglist;
	}

	public int getSavingsign() {
		return savingsign;
	}

	public void setSavingsign(int savingsign) {
		this.savingsign = savingsign;
	}

	public int getFinancesign() {
		return financesign;
	}

	public void setFinancesign(int financesign) {
		this.financesign = financesign;
	}

}
