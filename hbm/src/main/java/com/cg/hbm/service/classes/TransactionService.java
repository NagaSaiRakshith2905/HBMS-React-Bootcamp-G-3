package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Transactions;
import com.cg.hbm.service.interfaces.ITransactionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionService implements ITransactionService {
    @Override
    public Transactions addTransaction(Transactions transaction) {
        return null;
    }
}
