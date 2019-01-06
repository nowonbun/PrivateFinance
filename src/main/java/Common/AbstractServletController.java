package Common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import Bean.MenuBean;
import Dao.MenuDao;
import Model.Menu;

public abstract class AbstractServletController extends AbstractController {
	
	protected void initMenu(ModelMap modelmap, HttpSession session) {
		List<Menu> menuList = FactoryDao.getDao(MenuDao.class).getData();
		List<MenuBean> menuBeanList = new ArrayList<>();
		for (Menu item : menuList.stream().sorted((x, y) -> Integer.compare(x.getSequence(), y.getSequence())).collect(Collectors.toList())) {
			if (!isViewRole(session, item.getViewrole())) {
				continue;
			}
			MenuBean bean = new MenuBean();
			bean.setIcon(item.getIcon());
			bean.setLink(item.getLink());
			bean.setName(Util.localization(item.getName(), getCurrentUser(session).getLanguaueType().getCode()));
			menuBeanList.add(bean);
		}
		modelmap.addAttribute("menu", menuBeanList);
	}
}
