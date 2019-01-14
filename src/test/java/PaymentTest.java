import java.util.List;

import Common.FactoryDao;
import Dao.PaymentDao;
import Model.Payment;

public class PaymentTest {
	public static void main(String... args) {
		List<Payment> list =  FactoryDao.getDao(PaymentDao.class).getDataByYearMonth(2019, 1);
		for(Payment p : list) {
			System.out.println(p.getContents());
		}
	}
}
