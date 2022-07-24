package com.cg.hbm.controller;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Payments;
import com.cg.hbm.entities.Transactions;
import com.cg.hbm.pojo.PaymentPojo;
import com.cg.hbm.pojo.TransactionPojo;
import com.cg.hbm.service.classes.BookingDetailsService;
import com.cg.hbm.service.classes.PaymentService;
import com.cg.hbm.service.classes.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/transaction/")
@CrossOrigin(origins = "*")
public class PaymentManagementController {

    @Autowired
    BookingDetailsService bookingDetailsService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    PaymentService paymentService;

    @PostMapping("make_transaction/")
    public Payments makeTransaction(@RequestBody TransactionPojo transactionPojo) {
        Transactions transaction = transactionService.addTransaction(new Transactions(transactionPojo.getAmount()));
        BookingDetails bookingDetails = bookingDetailsService.showBookingDetails(transactionPojo.getBooking_id());
        Payments payments = new Payments(bookingDetails, transaction);
        return paymentService.addPayment(payments);
    }

    @GetMapping("view_payment/")
    public PaymentPojo viewPayment(@RequestParam int payment_id) {
        return paymentService.viewPayment(payment_id);
    }

    @GetMapping("view_all_payment/")
    public List<PaymentPojo> viewAllPayment() {
        return paymentService.viewAllPayment();
    }
}


