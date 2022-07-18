package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Payments;
import com.cg.hbm.entities.Transactions;
import com.cg.hbm.pojo.PaymentPojo;
import com.cg.hbm.pojo.TransactionPojo;

import java.util.List;


public interface IPaymentService {
    public Payments addPayment(Transactions transactions, BookingDetails bookingDetails);

    PaymentPojo viewPayment(int payment_id);
    List<PaymentPojo> viewAllPayment();

}
