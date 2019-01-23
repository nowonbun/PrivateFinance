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
		getLogger().info("[" + getCurrentUser(session).getId() + "] getUserList.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the ADMN of role permission.");
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
		getLogger().info("[" + getCurrentUser(session).getId() + "] getUser.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the ADMN of role permission.");
			res.setStatus(403);
			return;
		}
		String q = req.getParameter("q");
		getLogger().info("[" + getCurrentUser(session).getId() + "] q - " + q);
		if (q == null) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null!");
			res.setStatus(403);
			return;
		}
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
		getLogger().info("[" + getCurrentUser(session).getId() + "] modifyUser.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the ADMN of role permission.");
			res.setStatus(403);
			return;
		}
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String[] group = req.getParameterMap().get("group[]");

		getLogger().info("[" + getCurrentUser(session).getId() + "] id - " + id);
		getLogger().info("[" + getCurrentUser(session).getId() + "] name - " + name);
		getLogger().info("[" + getCurrentUser(session).getId() + "] country - " + country);
		getLogger().info("[" + getCurrentUser(session).getId() + "] group - " + group);
		if (id == null || name == null || country == null || group == null) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null!");
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
		getLogger().info("[" + getCurrentUser(session).getId() + "] deleteOrActiveUser.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the ADMN of role permission.");
			res.setStatus(403);
			return;
		}
		String id = req.getParameter("id");
		getLogger().info("[" + getCurrentUser(session).getId() + "] id - " + id);
		if (id == null) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null!");
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
		getLogger().info("[" + getCurrentUser(session).getId() + "] resetMaster.ajax");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the ADMN of role permission.");
			res.setStatus(403);
			return;
		}
		FactoryDao.resetMaster();
		ObjectBean bean = new ObjectBean();
		bean.setRet(true);
		returnAjax(res, bean);
	}
}
