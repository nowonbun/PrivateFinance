package Controller.Servlet;

import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Common.AbstractServletController;
import Common.Define;
import Common.FactoryDao;
import Common.Util;
import Dao.GroupDao;
import Dao.LanguageTypeDao;
import Dao.UserDao;
import Model.User;

@Controller
public class LoginController extends AbstractServletController {
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		session.setAttribute(Define.USER_SESSION_NAME, null);
		return "index";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		if (Util.StringIsEmptyOrNull(id) || Util.StringIsEmptyOrNull(email) || Util.StringIsEmptyOrNull(name)) {
			res.setStatus(403);
			return null;
		}

		User user = FactoryDao.getDao(UserDao.class).getUser(id);
		if (user == null) {
			user = new User();
			user.setId(id);
			user.setEmail(email);
			user.setName(name);
			user.setGroups(FactoryDao.getDao(GroupDao.class).getData().stream().filter(x -> x.getIsdefault()).collect(Collectors.toList()));
			user.setLanguaueType(FactoryDao.getDao(LanguageTypeDao.class).getData().stream().filter(x -> x.getCode().equals("0")).findFirst().get());
			user.setdeleted(false);
			user.setCreateddate(new Date());
			FactoryDao.getDao(UserDao.class).create(user);
		}

		if (!Util.StringEquals(user.getEmail(), email)) {
			res.setStatus(403);
			return null;
		}

		session.setAttribute(Define.USER_SESSION_NAME, user);

		return "redirect:main.html";
	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		session.setAttribute(Define.USER_SESSION_NAME, null);
		return "index";
	}
}
