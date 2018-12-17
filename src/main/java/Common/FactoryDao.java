package Common;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import Dao.ActionroleDao;
import Dao.GroupDao;
import Dao.LanguageTypeDao;
import Dao.LocalizationDao;
import Dao.LowCategoryDao;
import Dao.ViewroleDao;

public class FactoryDao {
	private static FactoryDao instance = null;
	private Map<Class<?>, AbstractDao<?>> flyweight = null;

	@SuppressWarnings("unchecked")
	public static <T> T getDao(Class<T> clz) {
		try {
			if (instance == null) {
				instance = new FactoryDao();
			}
			if (instance.flyweight == null) {
				instance.flyweight = new HashMap<Class<?>, AbstractDao<?>>();
			}
			if (!instance.flyweight.containsKey(clz)) {
				Constructor<T> constructor = clz.getDeclaredConstructor();
				constructor.setAccessible(true);
				instance.flyweight.put(clz, (AbstractDao<?>) constructor.newInstance());
			}
			return (T) instance.flyweight.get(clz);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static void initializeMaster() {
		resetMaster();
	}

	public static void resetMaster() {
		FactoryDao.getDao(ActionroleDao.class).reset();
		FactoryDao.getDao(GroupDao.class).reset();
		FactoryDao.getDao(LanguageTypeDao.class).reset();
		FactoryDao.getDao(LocalizationDao.class).reset();
		FactoryDao.getDao(LowCategoryDao.class).reset();
		FactoryDao.getDao(ViewroleDao.class).reset();
	}
}
