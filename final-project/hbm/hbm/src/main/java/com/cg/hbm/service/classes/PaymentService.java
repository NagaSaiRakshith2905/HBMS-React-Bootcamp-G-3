package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Payments;
import com.cg.hbm.exception_handler.BookingDetailsNotFoundException;
import com.cg.hbm.exception_handler.PaymentsNotFoundException;
import com.cg.hbm.pojo.PaymentPojo;
import com.cg.hbm.repository.PaymentRepository;
import com.cg.hbm.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payments addPayment(Payments payments) {

        return paymentRepository.save(payments);
    }

    @Override
    public PaymentPojo viewPayment(int payment_id) {

        Optional<Payments> optionalPayments = paymentRepository.findById(payment_id);
        if (optionalPayments.isEmpty())
            throw new PaymentsNotFoundException("Payment not found of ID:" + payment_id);
        PaymentPojo paymentPojo = new PaymentPojo();
        paymentPojo.setPayment_id(optionalPayments.get().getPayment_id());
        paymentPojo.setBooking_id(optionalPayments.get().getBookingDetails().getBooking_id());
        paymentPojo.setTransaction_id(optionalPayments.get().getTransactions().getTransaction_id());
        paymentPojo.setTransaction_date(optionalPayments.get().getTransactions().getTransaction_date());
        paymentPojo.setAmount(optionalPayments.get().getTransactions().getAmount());
        return paymentPojo;
    }

    @Override
    public List<PaymentPojo> viewAllPayment() {
        List<Payments> paymentsList = paymentRepository.findAll();
        List<PaymentPojo> paymentPojoList = new ArrayList<>();
        for (Payments payments : paymentsList) {
            PaymentPojo paymentPojo = new PaymentPojo();
            paymentPojo.setPayment_id(payments.getPayment_id());
            paymentPojo.setBooking_id(payments.getBookingDetails().getBooking_id());
            paymentPojo.setTransaction_id(payments.getTransactions().getTransaction_id());
            paymentPojo.setTransaction_date(payments.getTransactions().getTransaction_date());
            paymentPojo.setAmount(payments.getTransactions().getAmount());
            paymentPojoList.add(paymentPojo);
        }
        return paymentPojoList;
    }
}
