import java.util.List;
import Common.FactoryDao;
import Dao.LowCategoryDao;
import Model.LowCategory;

public class DaoTest {
	public static void main(String... arg) {
		List<LowCategory> list = FactoryDao.getDao(LowCategoryDao.class).getData();
		for (LowCategory item : list) {
			System.out.println(item.getName());
		}
	}
}
