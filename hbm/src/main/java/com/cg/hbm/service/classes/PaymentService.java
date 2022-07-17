package com.cg.hbm.service.classes;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Payments;
import com.cg.hbm.entities.Transactions;
import com.cg.hbm.pojo.TransactionPojo;
import com.cg.hbm.repository.PaymentRepository;
import com.cg.hbm.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payments addPayment(Transactions transactions, BookingDetails bookingDetails) {
        Payments payments = new Payments(bookingDetails, transactions);
        return paymentRepository.save(payments);
    }
}
