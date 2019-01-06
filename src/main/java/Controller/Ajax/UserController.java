package Controller.Ajax;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Bean.Select2AjaxBean;
import Bean.Select2AjaxItem;
import Bean.UserBean;
import Common.AbstractAjaxController;
import Common.FactoryDao;
import Dao.UserDao;
import Dao.ViewroleDao;
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
			bean.setDeleted(user.getIsdelted());
			ret.add(bean);
		}
		returnAjax(res, ret);
	}

	@RequestMapping(value = "/getUser.ajax")
	public void getUser(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
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
}
