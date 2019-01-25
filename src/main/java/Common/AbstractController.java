package Common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import Model.Group;
import Model.User;
import Model.Viewrole;

public class AbstractController {

	private Logger logger = null;

	protected Logger getLogger() {
		if (logger == null) {
			logger = LoggerManager.getLogger(this.getClass());
		}
		return logger;
	}

	protected User getCurrentUser(HttpSession session) {
		return (User) session.getAttribute(Define.USER_SESSION_NAME);
	}

	protected boolean isViewRole(HttpSession session, Viewrole role) {
		if (role == null) {
			return true;
		}
		for (Group rolegroup : role.getGroups()) {
			for (Group usergroup : getCurrentUser(session).getGroups()) {
				if (Util.StringEquals(rolegroup.getCode(), usergroup.getCode())) {
					return true;
				}
			}
		}
		for (User roleuser : role.getUsers()) {
			if (Util.StringEquals(roleuser.getId(), getCurrentUser(session).getId())) {
				return true;
			}
		}
		return false;
	}

	protected Cookie[] getCookies(HttpServletRequest request) {
		return request.getCookies();
	}

	protected Cookie getCookie(HttpServletRequest request, String name) {
		return Util.searchArray(getCookies(request), (node) -> {
			return Util.StringEquals(name, node.getName());
		});
	}
}
