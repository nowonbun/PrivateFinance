package Controller.Ajax;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Bean.ObjectBean;
import Bean.Select2AjaxBean;
import Bean.Select2AjaxItem;
import Bean.UserBean;
import Common.AbstractAjaxController;
import Common.Define;
import Common.FactoryDao;
import Dao.GroupDao;
import Dao.LanguageTypeDao;
import Dao.UserDao;
import Dao.ViewroleDao;
import Model.Group;
import Model.User;

@Controller
public class UserController extends AbstractAjaxController {
	@RequestMapping(value = "/getUserList.ajax")
	public void getUserList(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		List<User> userlist = FactoryDao.getDao(UserDao.class).getUserAll();
		List<UserBean> ret = new ArrayList<>();
		for (User user : userlist) {
			UserBean bean = new UserBean();
			bean.setId(user.getId());
			bean.setEmail(user.getEmail());
			bean.setName(user.getName());
			bean.setCountry(user.getLanguaueType().getCode());
			bean.setGroup(new ArrayList<>());
			for (Group group : user.getGroups()) {
				bean.getGroup().add(group.getCode());
			}
			bean.setDeleted(user.Isdeleted());
			ret.add(bean);
		}
		returnAjax(res, ret);
	}

	@RequestMapping(value = "/getUser.ajax")
	public void getUser(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String q = req.getParameter("q");
		List<User> userlist = FactoryDao.getDao(UserDao.class).getUserLikeEmail(q);
		Select2AjaxBean ret = new Select2AjaxBean();
		ret.setResults(new ArrayList<>());
		for (User user : userlist) {
			Select2AjaxItem item = new Select2AjaxItem();
			item.setId(user.getId());
			item.setText(user.getEmail());
			ret.getResults().add(item);
		}
		returnAjax(res, ret);
	}

	@RequestMapping(value = "/modifyUser.ajax")
	public void modifyUser(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String[] group = req.getParameterMap().get("group[]");

		if (id == null || name == null || country == null || group == null) {
			res.setStatus(403);
			return;
		}
		User user = FactoryDao.getDao(UserDao.class).getUser(id);
		user.setName(name);
		user.setLanguaueType(FactoryDao.getDao(LanguageTypeDao.class).getLanuageType(country));
		user.getGroups().clear();
		for (String g : group) {
			user.getGroups().add(FactoryDao.getDao(GroupDao.class).getGroup(g));
		}
		FactoryDao.getDao(UserDao.class).update(user);

		user = getCurrentUser(session);
		if (user.getId().equals(id)) {
			session.setAttribute(Define.USER_SESSION_NAME, FactoryDao.getDao(UserDao.class).getUser(id));
		}
		ObjectBean bean = new ObjectBean();
		bean.setRet(true);
		returnAjax(res, bean);
	}

	@RequestMapping(value = "/deleteOrActiveUser.ajax")
	public void deleteOrActiveUser(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String id = req.getParameter("id");
		if (id == null) {
			res.setStatus(403);
			return;
		}
		User user = FactoryDao.getDao(UserDao.class).getUser(id);
		user.setdeleted(!user.Isdeleted());
		FactoryDao.getDao(UserDao.class).update(user);

		user = getCurrentUser(session);
		if (user.getId().equals(id)) {
			session.setAttribute(Define.USER_SESSION_NAME, FactoryDao.getDao(UserDao.class).getUser(id));
		}
		ObjectBean bean = new ObjectBean();
		bean.setRet(user.Isdeleted());
		returnAjax(res, bean);
	}

	@RequestMapping(value = "/resetMaster.ajax")
	public void resetMaster(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		FactoryDao.resetMaster();
		ObjectBean bean = new ObjectBean();
		bean.setRet(true);
		returnAjax(res, bean);
	}
}
