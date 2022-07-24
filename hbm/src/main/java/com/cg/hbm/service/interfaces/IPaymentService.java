package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.Payments;
import com.cg.hbm.pojo.PaymentPojo;

import java.util.List;


public interface IPaymentService {
    public Payments addPayment(Payments payments);

    PaymentPojo viewPayment(int payment_id);
    List<PaymentPojo> viewAllPayment();

}
