package Common;

import javax.servlet.http.HttpSession;

import Model.Group;
import Model.User;
import Model.Viewrole;

public class AbstractController {
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
}
