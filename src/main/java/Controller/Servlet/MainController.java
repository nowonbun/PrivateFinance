package Controller.Servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Bean.CategoryBean;
import Bean.SelectionBean;
import Common.AbstractServletController;
import Common.FactoryDao;
import Common.JsonConverter;
import Common.PropertyMap;
import Common.Util;
import Dao.ActionroleDao;
import Dao.CategoryDao;
import Dao.GroupDao;
import Dao.LanguageTypeDao;
import Dao.LowCategoryDao;
import Dao.ViewroleDao;
import Model.Actionrole;
import Model.Category;
import Model.Group;
import Model.LanguageType;
import Model.LowCategory;
import Model.Viewrole;

@Controller
public class MainController extends AbstractServletController {
	@RequestMapping(value = "/main.html")
	public String main(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] main.html");
		super.initMenu(modelmap, session);
		return "main";
	}

	@RequestMapping(value = "/category.html")
	public String category(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] category.html");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("CTGV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the CTGV of role permission.");
			res.setStatus(403);
			return "";
		}
		super.initMenu(modelmap, session);

		modelmap.addAttribute("income", getCategoryList(LowCategoryDao.INCOME));
		modelmap.addAttribute("expenditure", getCategoryList(LowCategoryDao.EXPENDITURE));
		modelmap.addAttribute("saving", getCategoryList(LowCategoryDao.SAVING));
		modelmap.addAttribute("withdraw", getCategoryList(LowCategoryDao.WITHDRAW));

		return "category";
	}

	private List<CategoryBean> getCategoryList(String lowCode) {
		List<CategoryBean> ret = new ArrayList<>();
		for (Category category : FactoryDao.getDao(CategoryDao.class).getCategoryList(FactoryDao.getDao(LowCategoryDao.class).getLowCategory(lowCode))) {
			CategoryBean bean = new CategoryBean();
			bean.setId(category.getIdx());
			bean.setName(category.getName());
			if (category.getIsdeleted()) {
				bean.setDel(2);
			} else {
				bean.setDel(1);
			}
			ret.add(bean);
		}
		return ret;
	}

	@RequestMapping(value = "/saveCategory.html", method = RequestMethod.POST)
	public String saveCategory(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] saveCategory.html");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("CTGV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the CTGV of role permission.");
			res.setStatus(403);
			return "";
		}
		String income = req.getParameter("income");
		String expenditure = req.getParameter("expenditure");
		String saving = req.getParameter("saving");
		String withdraw = req.getParameter("withdraw");
		getLogger().info("[" + getCurrentUser(session).getId() + "] income - " + income);
		getLogger().info("[" + getCurrentUser(session).getId() + "] expenditure - " + expenditure);
		getLogger().info("[" + getCurrentUser(session).getId() + "] saving - " + saving);
		getLogger().info("[" + getCurrentUser(session).getId() + "] withdraw - " + withdraw);
		if (income == null || expenditure == null || saving == null || withdraw == null) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The parameter is null!");
			res.setStatus(403);
			return "";
		}
		updateCategory(convertCategoryItem(income), LowCategoryDao.INCOME, session);
		updateCategory(convertCategoryItem(expenditure), LowCategoryDao.EXPENDITURE, session);
		updateCategory(convertCategoryItem(saving), LowCategoryDao.SAVING, session);
		updateCategory(convertCategoryItem(withdraw), LowCategoryDao.WITHDRAW, session);
		FactoryDao.resetMaster();
		
		modelmap.addAttribute("categoryupdated", true);
		return category(modelmap, session, req, res);
	}

	private void updateCategory(List<CategoryBean> list, String code, HttpSession session) {
		for (CategoryBean bean : list) {
			Category category;
			if(Util.StringIsEmptyOrNull(bean.getName())) {
				if (bean.getId() > 0) {
					category = FactoryDao.getDao(CategoryDao.class).getCategory(bean.getId());
					category.setIsdeleted(true);
					FactoryDao.getDao(CategoryDao.class).update(category);
				}
				continue;
			}
			if (bean.getId() > 0) {
				category = FactoryDao.getDao(CategoryDao.class).getCategory(bean.getId());
				category.setIsdeleted(bean.getDel() == 2);
			} else {
				category = new Category();
				category.setIsdeleted(false);
				category.setCreateddate(new Date());
				category.setCreater(super.getCurrentUser(session));
			}
			category.setName(bean.getName());
			category.setMstLowCategory(FactoryDao.getDao(LowCategoryDao.class).getLowCategory(code));
			category.setUpdateddate(new Date());
			category.setUpdater(super.getCurrentUser(session));
			FactoryDao.getDao(CategoryDao.class).update(category);
		}
	}

	private List<CategoryBean> convertCategoryItem(String val) {
		return JsonConverter.parseArray(val, (obj) -> {
			List<CategoryBean> ret = new ArrayList<>();
			for (int i = 0; i < obj.size(); i++) {
				CategoryBean item = JsonConverter.parseObject(obj.get(i).toString(), (obj2) -> {
					try {
						CategoryBean bean = new CategoryBean();
						bean.setId(Integer.parseInt(obj2.getString("id")));
						bean.setName(obj2.getString("name"));
						bean.setDel(Integer.parseInt(obj2.getString("del")));
						return bean;
					} catch (Throwable e) {
						return null;
					}
				});
				if (item != null) {
					ret.add(item);
				}
			}
			return ret;
		});
	}

	@RequestMapping(value = "/admin.html")
	public String admin(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] admin.html");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("ADMN"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the ADMN of role permission.");
			res.setStatus(403);
			return "";
		}
		super.initMenu(modelmap, session);
		List<SelectionBean> countryList = new ArrayList<>();
		for (LanguageType item : FactoryDao.getDao(LanguageTypeDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), session));
			countryList.add(bean);
		}
		List<SelectionBean> groupList = new ArrayList<>();
		for (Group item : FactoryDao.getDao(GroupDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), session));
			groupList.add(bean);
		}
		List<SelectionBean> viewrolelist = new ArrayList<>();
		for (Viewrole item : FactoryDao.getDao(ViewroleDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), session));
			viewrolelist.add(bean);
		}
		List<SelectionBean> actionrolelist = new ArrayList<>();
		for (Actionrole item : FactoryDao.getDao(ActionroleDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setValue(item.getCode());
			bean.setName(Util.localization(item.getName(), session));
			actionrolelist.add(bean);
		}
		modelmap.addAttribute("country", countryList);
		modelmap.addAttribute("group", groupList);
		modelmap.addAttribute("viewrole", viewrolelist);
		modelmap.addAttribute("actionrole", actionrolelist);

		return "admin";
	}

	@RequestMapping(value = "/finance.html")
	public String finance(ModelMap modelmap, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		getLogger().info("[" + getCurrentUser(session).getId() + "] admin.html");
		if (!super.isViewRole(session, FactoryDao.getDao(ViewroleDao.class).getRole("PFNV"))) {
			getLogger().error("[" + getCurrentUser(session).getId() + "] The user do not have the PFNV of role permission.");
			res.setStatus(403);
			return "";
		}
		super.initMenu(modelmap, session);

		List<SelectionBean> yearlist = new ArrayList<>();
		int yearstart = PropertyMap.getInstance().getPropertyInt("config", "year-start");
		int yearend = PropertyMap.getInstance().getPropertyInt("config", "year-end");
		for (int i = yearstart; i <= yearend; i++) {
			SelectionBean bean = new SelectionBean();
			bean.setName(String.valueOf(i));
			bean.setValue(String.valueOf(i));
			yearlist.add(bean);
		}
		List<SelectionBean> monthlist = new ArrayList<>();
		int monthstart = PropertyMap.getInstance().getPropertyInt("config", "month-start");
		int monthend = PropertyMap.getInstance().getPropertyInt("config", "month-end");
		for (int i = monthstart; i <= monthend; i++) {
			SelectionBean bean = new SelectionBean();
			bean.setName(String.valueOf(i));
			bean.setValue(String.valueOf(i));
			monthlist.add(bean);
		}
		List<SelectionBean> daylist = new ArrayList<>();
		int daystart = PropertyMap.getInstance().getPropertyInt("config", "day-start");
		int dayend = PropertyMap.getInstance().getPropertyInt("config", "day-end");
		for (int i = daystart; i <= dayend; i++) {
			SelectionBean bean = new SelectionBean();
			bean.setName(String.valueOf(i));
			bean.setValue(String.valueOf(i));
			daylist.add(bean);
		}

		List<SelectionBean> lowcategory = new ArrayList<>();
		Map<String, List<SelectionBean>> category = new HashMap<>();
		for (LowCategory item : FactoryDao.getDao(LowCategoryDao.class).getData()) {
			SelectionBean bean = new SelectionBean();
			bean.setName(Util.localization(item.getName(), session));
			bean.setValue(item.getCode());
			lowcategory.add(bean);
			if (!category.containsKey(item.getCode())) {
				category.put(item.getCode(), new ArrayList<>());
			}
			List<SelectionBean> sub = category.get(item.getCode());
			for (Category item2 : item.getCategories()) {
				SelectionBean bean2 = new SelectionBean();
				bean2.setName(Util.localization(item2.getName(), session));
				bean2.setValue(Integer.toString(item2.getIdx()));
				sub.add(bean2);
			}
		}

		modelmap.addAttribute("yearlist", yearlist);
		modelmap.addAttribute("monthlist", monthlist);
		modelmap.addAttribute("daylist", daylist);
		modelmap.addAttribute("lowcategory", lowcategory);
		modelmap.addAttribute("categorymap", category);
		modelmap.addAttribute("categorykey", category.keySet().toArray());

		return "finance";
	}
}
