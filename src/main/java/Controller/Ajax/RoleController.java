package Controller.Ajax;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Bean.ObjectBean;
import Bean.RoleBean;
import Bean.RoleListBean;
import Common.AbstractAjaxController;
import Common.FactoryDao;
import Common.JsonConverter;
import Dao.ActionroleDao;
import Dao.GroupDao;
import Dao.UserDao;
import Dao.ViewroleDao;
import Model.Actionrole;
import Model.Group;
import Model.User;
import Model.Viewrole;

@Controller
public class RoleController extends AbstractAjaxController {
	@RequestMapping(value = "/getViewRole.ajax", method = RequestMethod.POST)
	public void getViewRole(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String type = req.getParameter("type");
		String name = req.getParameter("name");
		if (type == null || name == null) {
			res.setStatus(403);
			return;
		}
		RoleListBean list = new RoleListBean();
		if ("0".equals(type)) {
			Group group = FactoryDao.getDao(GroupDao.class).getGroup(name);
			if (group == null) {
				list.setSearch(false);
			} else {
				list.setSearch(true);
				list.setBeanlist(new ArrayList<>());
				for (Viewrole role : group.getViewroles()) {
					RoleBean bean = new RoleBean();
					list.getBeanlist().add(bean);
					bean.setCode(role.getCode());
				}
			}

		} else if ("1".equals(type)) {
			User user = FactoryDao.getDao(UserDao.class).getUser(name);
			if (user == null) {
				list.setSearch(false);
			} else {
				list.setSearch(true);
				list.setBeanlist(new ArrayList<>());
				for (Viewrole role : user.getViewroles()) {
					RoleBean bean = new RoleBean();
					list.getBeanlist().add(bean);
					bean.setCode(role.getCode());
				}
			}
		} else {
			list.setSearch(false);
		}
		returnAjax(res, list);
	}

	@RequestMapping(value = "/getActionRole.ajax", method = RequestMethod.POST)
	public void getActionRole(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String type = req.getParameter("type");
		String name = req.getParameter("name");
		if (type == null || name == null) {
			res.setStatus(403);
			return;
		}
		RoleListBean list = new RoleListBean();
		if ("0".equals(type)) {
			Group group = FactoryDao.getDao(GroupDao.class).getGroup(name);
			if (group == null) {
				list.setSearch(false);
			} else {
				list.setSearch(true);
				list.setBeanlist(new ArrayList<>());
				for (Actionrole role : group.getActionroles()) {
					RoleBean bean = new RoleBean();
					list.getBeanlist().add(bean);
					bean.setCode(role.getCode());
				}
			}

		} else if ("1".equals(type)) {
			User user = FactoryDao.getDao(UserDao.class).getUser(name);
			if (user == null) {
				list.setSearch(false);
			} else {
				list.setSearch(true);
				list.setBeanlist(new ArrayList<>());
				for (Actionrole role : user.getActionroles()) {
					RoleBean bean = new RoleBean();
					list.getBeanlist().add(bean);
					bean.setCode(role.getCode());
				}
			}
		} else {
			list.setSearch(false);
		}
		returnAjax(res, list);
	}

	@RequestMapping(value = "/saveViewRole.ajax", method = RequestMethod.POST)
	public void saveViewRole(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String type = req.getParameter("type");
		String name = req.getParameter("name");
		String data = req.getParameter("data");
		if (type == null || name == null || data == null) {
			res.setStatus(403);
			return;
		}
		List<String> list = new ArrayList<>();
		JsonConverter.parseArray(data, (obj) -> {
			for (int i = 0; i < obj.size(); i++) {
				list.add(obj.getString(i));
			}
			return true;
		});
		ObjectBean bean = new ObjectBean();
		if ("0".equals(type)) {
			Group group = FactoryDao.getDao(GroupDao.class).getGroup(name);
			if (group != null) {
				group.getViewroles().clear();
				for (String code : list) {
					Viewrole role = FactoryDao.getDao(ViewroleDao.class).getRole(code);
					group.getViewroles().add(role);
				}
				FactoryDao.getDao(GroupDao.class).update(group);
				bean.setRet(true);
			} else {
				bean.setRet(false);
			}
		} else if ("1".equals(type)) {
			User user = FactoryDao.getDao(UserDao.class).getUser(name);
			if (user != null) {
				user.getViewroles().clear();
				for (String code : list) {
					Viewrole role = FactoryDao.getDao(ViewroleDao.class).getRole(code);
					user.getViewroles().add(role);
				}
				FactoryDao.getDao(UserDao.class).update(user);
				bean.setRet(true);
			} else {
				bean.setRet(false);
			}
		} else {
			bean.setRet(false);
		}
		returnAjax(res, bean);
	}
	
	@RequestMapping(value = "/saveActionRole.ajax", method = RequestMethod.POST)
	public void saveActionRole(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			res.setStatus(403);
			return;
		}
		String type = req.getParameter("type");
		String name = req.getParameter("name");
		String data = req.getParameter("data");
		if (type == null || name == null || data == null) {
			res.setStatus(403);
			return;
		}
		List<String> list = new ArrayList<>();
		JsonConverter.parseArray(data, (obj) -> {
			for (int i = 0; i < obj.size(); i++) {
				list.add(obj.getString(i));
			}
			return true;
		});
		ObjectBean bean = new ObjectBean();
		if ("0".equals(type)) {
			Group group = FactoryDao.getDao(GroupDao.class).getGroup(name);
			if (group != null) {
				group.getActionroles().clear();
				for (String code : list) {
					Actionrole role = FactoryDao.getDao(ActionroleDao.class).getRole(code);
					group.getActionroles().add(role);
				}
				FactoryDao.getDao(GroupDao.class).update(group);
				bean.setRet(true);
			} else {
				bean.setRet(false);
			}
		} else if ("1".equals(type)) {
			User user = FactoryDao.getDao(UserDao.class).getUser(name);
			if (user != null) {
				user.getActionroles().clear();
				for (String code : list) {
					Actionrole role = FactoryDao.getDao(ActionroleDao.class).getRole(code);
					user.getActionroles().add(role);
				}
				FactoryDao.getDao(UserDao.class).update(user);
				bean.setRet(true);
			} else {
				bean.setRet(false);
			}
		} else {
			bean.setRet(false);
		}
		returnAjax(res, bean);
	}
}
