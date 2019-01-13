package Controller.Ajax;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Common.AbstractAjaxController;
import Common.FactoryDao;
import Common.Util;
import Dao.ViewroleDao;
import Model.Payment;

@Controller
public class PaymentController extends AbstractAjaxController {

	@RequestMapping(value = "/setPaymentItem.ajax", method = RequestMethod.POST)
	public void getViewRole(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			res.setStatus(403);
		}
		String pDate = req.getParameter("date");
		String pType = req.getParameter("type");
		String pCategory = req.getParameter("category");
		String pContents = req.getParameter("contents");
		String pPrice = req.getParameter("price");
		
		if(Util.StringIsEmptyOrNull(pDate)) {
			res.setStatus(403);
			return;
		}
		if(Util.StringIsEmptyOrNull(pType)) {
			res.setStatus(403);
			return;
		}
		if(Util.StringIsEmptyOrNull(pCategory)) {
			res.setStatus(403);
			return;
		}
		if(Util.StringIsEmptyOrNull(pContents)) {
			res.setStatus(403);
			return;
		}
		if(Util.StringIsEmptyOrNull(pPrice)) {
			res.setStatus(403);
			return;
		}
		
	}
}
