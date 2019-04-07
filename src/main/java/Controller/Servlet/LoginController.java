package Controller.Servlet;

import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
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
import Dao.LoginCookieDao;
import Dao.UserDao;
import Model.LoginCookie;
import Model.User;

@Controller
public class LoginController extends AbstractServletController {
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("index.html");
		session.setAttribute(Define.USER_SESSION_NAME, null);
		Cookie cookie = getCookie(req, Util.COOKIE_KEY);
		if (cookie != null) {
			String key = cookie.getValue();
			LoginCookie loginCookie = FactoryDao.getDao(LoginCookieDao.class).getLoginCookieByKey(key);
			if (loginCookie != null) {
				session.setAttribute(Define.USER_SESSION_NAME, loginCookie.getUser());
				return "redirect:main.html";
			}
			cookie.setPath(Util.getCookiePath());
			cookie.setMaxAge(0);
			res.addCookie(cookie);
		}
		return "index";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("login.html");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		getLogger().info("id - " + id);
		getLogger().info("email - " + email);
		getLogger().info("name - " + name);
		if (Util.StringIsEmptyOrNull(id) || Util.StringIsEmptyOrNull(email) || Util.StringIsEmptyOrNull(name)) {
			getLogger().error("The parameter is null!");
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
			user.setLanguaueType(FactoryDao.getDao(LanguageTypeDao.class).getData().stream().filter(x -> x.getCode().equals(Define.LANGUAGE_TYPE_ENG)).findFirst().get());
			user.setdeleted(false);
			user.setCreateddate(new Date());
			FactoryDao.getDao(UserDao.class).create(user);
		}

		if (!Util.StringEquals(user.getEmail(), email)) {
			getLogger().error("The id and email is not match!");
			res.setStatus(403);
			return null;
		}

		session.setAttribute(Define.USER_SESSION_NAME, user);
		String key = Util.createCookieKey();
		FactoryDao.getDao(LoginCookieDao.class).clearLoginCookie(user);
		LoginCookie logincookie = new LoginCookie();
		logincookie.setUser(user);
		logincookie.setCookiekey(key);
		logincookie.setCreateddate(new Date());
		logincookie.setIsdeleted(false);
		FactoryDao.getDao(LoginCookieDao.class).update(logincookie);

		Cookie cookie = new Cookie(Util.COOKIE_KEY, key);
		cookie.setMaxAge(Util.getCookieExpire());
		cookie.setPath(Util.getCookiePath());
		res.addCookie(cookie);

		return "redirect:main.html";
	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("logout.html");
		FactoryDao.getDao(LoginCookieDao.class).clearLoginCookie(getCurrentUser(session));
		session.setAttribute(Define.USER_SESSION_NAME, null);
		Cookie cookie = getCookie(req, Util.COOKIE_KEY);
		if (cookie != null) {
			cookie.setPath(Util.getCookiePath());
			cookie.setMaxAge(0);
			res.addCookie(cookie);
		}
		return "redirect:index.html";
	}
}
