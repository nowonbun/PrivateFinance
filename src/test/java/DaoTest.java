import java.util.List;
import Common.FactoryDao;
import Dao.LowCategoryDao;
import Dao.MenuDao;
import Model.LowCategory;
import Model.Menu;

public class DaoTest {
	public static void main(String... arg) {
		List<Menu> list = FactoryDao.getDao(MenuDao.class).getData();
		for (Menu item : list) {
			System.out.println(item.getName());
		}
	}
}
