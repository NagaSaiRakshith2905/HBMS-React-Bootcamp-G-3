package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Transactions;
import com.cg.hbm.repository.TransactionRepository;
import com.cg.hbm.service.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    public Transactions addTransaction(Transactions transaction) {
        String date = LocalDate.now().toString();
        transaction.setTransaction_date(date);
        return repository.save(transaction);
    }
}
