package Controller.Ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Common.AbstractAjaxController;
import Common.FactoryDao;
import Dao.ViewroleDao;

@Controller
public class PaymentController extends AbstractAjaxController {

	@RequestMapping(value = "/setPaymentItem.ajax", method = RequestMethod.POST)
	public void getViewRole(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			res.setStatus(403);
		}
		String date = req.getParameter("date");
		String type = req.getParameter("type");
		String category = req.getParameter("category");
		String contents = req.getParameter("contents");
		String price = req.getParameter("price");
		
		System.out.println(date);
		System.out.println(type);
		System.out.println(category);
		System.out.println(contents);
		System.out.println(price);
	}
}
