package com.cg.hbm.controller;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Payments;
import com.cg.hbm.entities.Transactions;
import com.cg.hbm.pojo.TransactionPojo;
import com.cg.hbm.service.classes.BookingDetailsService;
import com.cg.hbm.service.classes.PaymentService;
import com.cg.hbm.service.classes.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/transaction/")

public class PaymentManagementController {

    @Autowired
    BookingDetailsService bookingDetailsService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    PaymentService paymentService;

    @PostMapping("make_transaction/")
    public Payments makeTransaction(@RequestBody TransactionPojo transactionPojo){
        Transactions transaction = transactionService.addTransaction(new Transactions(transactionPojo.getAmount()));
        BookingDetails bookingDetails = bookingDetailsService.showBookingDetails(transactionPojo.getBooking_id());
        return paymentService.addPayment(transaction,bookingDetails);
    }
}


