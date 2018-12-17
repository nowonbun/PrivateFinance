package Dao;

import Common.TransactionDao;
import Model.Payment;

public class PaymentDao extends TransactionDao<Payment> {
	protected PaymentDao() {
		super(Payment.class);
	}
}
