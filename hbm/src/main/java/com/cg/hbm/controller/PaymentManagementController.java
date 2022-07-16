package com.cg.hbm.controller;

import com.cg.hbm.entities.Transactions;
import com.cg.hbm.service.classes.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/transaction/")

public class PaymentManagementController {
    private TransactionService transactionService;
    @Autowired
    public PaymentManagementController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("add_transaction")
    public Transactions addTransaction(@RequestBody Transactions transaction){
        return transactionService.addTransaction(transaction);
    }
}


