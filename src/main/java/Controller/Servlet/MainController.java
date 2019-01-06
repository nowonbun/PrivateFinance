package Controller.Servlet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import Bean.SelectionBean;
import Common.AbstractServletController;
import Common.FactoryDao;
import Common.Util;
import Dao.ActionroleDao;
import Dao.GroupDao;
import Dao.LanguageTypeDao;
import Dao.ViewroleDao;
import Model.Actionrole;
import Model.Group;
import Model.LanguageType;
import Model.Viewrole;

@Controller
public class MainController extends AbstractServletController {
	@RequestMapping(value = "/main.html")
	public String main(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		super.initMenu(modelmap, session);

		return "main";
	}

	@RequestMapping(value = "/admin.html")
	public String admin(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		super.initMenu(modelmap, session);
		List<SelectionBean> countryList = new ArrayList<>();
		for (LanguageType item : FactoryDao.getDao(LanguageTypeDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), getCurrentUser(session).getLanguaueType().getCode()));
			countryList.add(bean);
		}
		List<SelectionBean> groupList = new ArrayList<>();
		for (Group item : FactoryDao.getDao(GroupDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), getCurrentUser(session).getLanguaueType().getCode()));
			groupList.add(bean);
		}
		List<SelectionBean> viewrolelist = new ArrayList<>();
		for (Viewrole item : FactoryDao.getDao(ViewroleDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), getCurrentUser(session).getLanguaueType().getCode()));
			viewrolelist.add(bean);
		}
		List<SelectionBean> actionrolelist = new ArrayList<>();
		for (Actionrole item : FactoryDao.getDao(ActionroleDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), getCurrentUser(session).getLanguaueType().getCode()));
			actionrolelist.add(bean);
		}
		modelmap.addAttribute("country", countryList);
		modelmap.addAttribute("group", groupList);
		modelmap.addAttribute("viewrole", viewrolelist);
		modelmap.addAttribute("actionrole", actionrolelist);

		return "admin";
	}
}
