package Controller.Ajax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Bean.FinanceBean;
import Bean.ObjectBean;
import Bean.PaymentBean;
import Common.AbstractAjaxController;
import Common.FactoryDao;
import Common.Util;
import Dao.CategoryDao;
import Dao.LowCategoryDao;
import Dao.PaymentDao;
import Dao.ViewroleDao;
import Model.Payment;

@Controller
public class PaymentController extends AbstractAjaxController {

	@RequestMapping(value = "/setPaymentItem.ajax", method = RequestMethod.POST)
	public void setPaymentItem(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] setPaymentItem.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the PFNV of role permission.");
			res.setStatus(403);
			return;
		}
		String pDate = req.getParameter("date");
		String pType = req.getParameter("type");
		String pCategory = req.getParameter("category");
		String pContents = req.getParameter("contents");
		String pPrice = req.getParameter("price");

		getLogger().info("[" + getCurrentUser(session).getId() + "] date - " + pDate);
		getLogger().info("[" + getCurrentUser(session).getId() + "] type - " + pType);
		getLogger().info("[" + getCurrentUser(session).getId() + "] category - " + pCategory);
		getLogger().info("[" + getCurrentUser(session).getId() + "] contents - " + pContents);
		getLogger().info("[" + getCurrentUser(session).getId() + "] price - " + pPrice);
		if (Util.StringIsEmptyOrNull(pDate)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : date");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pType)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : type");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pCategory)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : category");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pContents)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : contents");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pPrice)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : price");
			res.setStatus(403);
			return;
		}
		try {
			Payment payment = new Payment();
			payment.setDate(Util.getDateFromString(pDate));
			payment.setLowCategory(FactoryDao.getDao(LowCategoryDao.class).getLowCategory(pType));
			int category = Integer.parseInt(pCategory);
			payment.setCategory(FactoryDao.getDao(CategoryDao.class).getCategory(category));
			payment.setContents(pContents);
			BigDecimal money = new BigDecimal(pPrice);
			payment.setMoney(money);
			payment.setCreater(super.getCurrentUser(session));
			payment.setCreateddate(Util.getNow());
			
			FactoryDao.getDao(PaymentDao.class).update(payment);
			getLogger().info("[" + getCurrentUser(session).getId() + "] The payment item was updated.");

			ObjectBean bean = new ObjectBean();
			bean.setRet(true);
			returnAjax(res, bean);
		} catch (Throwable e) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] exception!");
			getLogger().error(e);
			res.setStatus(403);
			return;
		}
	}

	private boolean isSearchCondition(Payment item, int day, String type) {
		if (day != -1) {
			if (Util.getDay(item.getDate()) != day) {
				return false;
			}
		}
		if (!Util.StringIsEmptyOrNull(type)) {
			if (!type.equals(item.getLowCategory().getCode())) {
				return false;
			}
		}
		return true;
	}

	@RequestMapping(value = "/modifyPaymentItem.ajax", method = RequestMethod.POST)
	public void modifyPaymentItem(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] modifyPaymentItem.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the PFNV of role permission.");
			res.setStatus(403);
		}
		String pIdx = req.getParameter("idx");
		String pDate = req.getParameter("date");
		String pType = req.getParameter("type");
		String pCategory = req.getParameter("category");
		String pContents = req.getParameter("contents");
		String pPrice = req.getParameter("price");
		getLogger().info("[" + getCurrentUser(session).getId() + "] idx - " + pIdx);
		getLogger().info("[" + getCurrentUser(session).getId() + "] date - " + pDate);
		getLogger().info("[" + getCurrentUser(session).getId() + "] type - " + pType);
		getLogger().info("[" + getCurrentUser(session).getId() + "] category - " + pCategory);
		getLogger().info("[" + getCurrentUser(session).getId() + "] contents - " + pContents);
		getLogger().info("[" + getCurrentUser(session).getId() + "] price - " + pPrice);
		if (Util.StringIsEmptyOrNull(pIdx)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : idx");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pDate)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : date");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pType)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : type");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pCategory)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : category");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pContents)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : contents");
			res.setStatus(403);
			return;
		}
		if (Util.StringIsEmptyOrNull(pPrice)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : price");
			res.setStatus(403);
			return;
		}
		int idx = Integer.parseInt(pIdx);
		Payment payment = FactoryDao.getDao(PaymentDao.class).getDataByIdx(idx);
		ObjectBean bean = new ObjectBean();
		bean.setRet(false);
		if (payment != null) {
			payment.setDate(Util.getDateFromString(pDate));
			payment.setLowCategory(FactoryDao.getDao(LowCategoryDao.class).getLowCategory(pType));
			int category = Integer.parseInt(pCategory);
			payment.setCategory(FactoryDao.getDao(CategoryDao.class).getCategory(category));
			payment.setContents(pContents);
			BigDecimal money = new BigDecimal(pPrice);
			payment.setMoney(money);
			payment.setUpdater(super.getCurrentUser(session));
			payment.setUpdateddate(Util.getNow());
			FactoryDao.getDao(PaymentDao.class).update(payment);
			getLogger().info("[" + getCurrentUser(session).getId() + "] The payment item was updated.");
			bean.setRet(true);
		}
		returnAjax(res, bean);
	}

	@RequestMapping(value = "/deletePaymentItem.ajax", method = RequestMethod.POST)
	public void deletePaymentItem(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] modifyPaymentItem.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the PFNV of role permission.");
			res.setStatus(403);
		}
		String pIdx = req.getParameter("idx");
		getLogger().info("[" + getCurrentUser(session).getId() + "] idx - " + pIdx);
		if (Util.StringIsEmptyOrNull(pIdx)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : idx");
			res.setStatus(403);
			return;
		}
		int idx = Integer.parseInt(pIdx);
		Payment payment = FactoryDao.getDao(PaymentDao.class).getDataByIdx(idx);
		ObjectBean bean = new ObjectBean();
		bean.setRet(false);
		if (payment != null) {
			payment.setIsdeleted(true);
			payment.setUpdater(super.getCurrentUser(session));
			payment.setUpdateddate(Util.getNow());
			FactoryDao.getDao(PaymentDao.class).update(payment);
			getLogger().info("[" + getCurrentUser(session).getId() + "] The payment item was updated.");
			bean.setRet(true);
		}
		returnAjax(res, bean);
	}

	@RequestMapping(value = "/getPaymentItem.ajax", method = RequestMethod.POST)
	public void getPaymentItem(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] getPaymentItem.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the PFNV of role permission.");
			res.setStatus(403);
		}
		String pDate = req.getParameter("date");
		getLogger().info("[" + getCurrentUser(session).getId() + "] pDate - " + pDate);
		if (Util.StringIsEmptyOrNull(pDate)) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null! : date");
			res.setStatus(403);
			return;
		}
		String pDay = req.getParameter("day");
		String pType = req.getParameter("type");
		Date date = Util.getDateFromString(pDate);
		int year = Util.getYear(date);
		int month = Util.getMonth(date);

		List<Payment> list = FactoryDao.getDao(PaymentDao.class).getDataByYearMonth(year, month);
		FinanceBean ret = new FinanceBean();
		ret.setFinancelist(new ArrayList<>());
		ret.setSavinglist(new ArrayList<>());

		BigDecimal incomeTotal = BigDecimal.ZERO;
		BigDecimal expenditureTotal = BigDecimal.ZERO;
		BigDecimal savingTotal = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;
		int day = -1;
		if (!Util.StringIsEmptyOrNull(pDay)) {
			day = Integer.parseInt(pDay);
		}
		for (Payment item : list) {
			PaymentBean bean = new PaymentBean();
			bean.setIdx(item.getIdx());
			bean.setDay(String.valueOf(Util.getDay(item.getDate())));
			bean.setType_code(item.getLowCategory().getCode());
			bean.setType_disp(Util.localization(item.getLowCategory().getName(), session));
			bean.setCategory_code(String.valueOf(item.getCategory().getIdx()));
			bean.setCategory_disp(item.getCategory().getName());
			bean.setContents(item.getContents());
			bean.setMoney_disp(String.valueOf(item.getMoney()));
			if (LowCategoryDao.INCOME.equals(item.getLowCategory().getCode())) {
				incomeTotal = incomeTotal.add(item.getMoney());
				if (!isSearchCondition(item, day, pType)) {
					continue;
				}
				bean.setSign(1);
				total = total.add(item.getMoney());
			} else if (LowCategoryDao.EXPENDITURE.equals(item.getLowCategory().getCode())) {
				expenditureTotal = expenditureTotal.add(item.getMoney());
				if (day != -1) {
					if (Util.getDay(item.getDate()) != day) {
						continue;
					}
				}
				bean.setSign(-1);
				total = total.subtract(item.getMoney());
			} else if (LowCategoryDao.SAVING.equals(item.getLowCategory().getCode())) {
				expenditureTotal = expenditureTotal.add(item.getMoney());
				if (!isSearchCondition(item, day, pType)) {
					continue;
				}
				bean.setSign(-1);
				savingTotal = savingTotal.add(item.getMoney());
				total = total.subtract(item.getMoney());
				ret.getSavinglist().add(bean);
			} else if (LowCategoryDao.WITHDRAW.equals(item.getLowCategory().getCode())) {
				incomeTotal = incomeTotal.add(item.getMoney());
				if (!isSearchCondition(item, day, pType)) {
					continue;
				}
				bean.setSign(1);
				savingTotal = savingTotal.subtract(item.getMoney());
				total = total.add(item.getMoney());
				ret.getSavinglist().add(bean);
			}
			ret.getFinancelist().add(bean);
		}

		BigDecimal ts = new BigDecimal(FactoryDao.getDao(PaymentDao.class).getFullTotal(FactoryDao.getDao(LowCategoryDao.class).getLowCategory(LowCategoryDao.SAVING)).toString());
		BigDecimal td = new BigDecimal(FactoryDao.getDao(PaymentDao.class).getFullTotal(FactoryDao.getDao(LowCategoryDao.class).getLowCategory(LowCategoryDao.WITHDRAW)).toString());
		BigDecimal fs = ts.subtract(td);
		ret.setFinancesign(total.compareTo(BigDecimal.ZERO));
		ret.setFinanceTotal(total.abs().toString());
		ret.setSavingsign(savingTotal.compareTo(BigDecimal.ZERO));
		ret.setSavingTotal(savingTotal.abs().toString());

		ret.setIncomeTotal(incomeTotal.toString());
		ret.setExpenditureTotal(expenditureTotal.toString());
		ret.setFullSavingsign(fs.compareTo(BigDecimal.ZERO));
		ret.setFullSavingTotal(fs.abs().toString());
		returnAjax(res, ret);
	}
}
