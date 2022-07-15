package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Payments;
import com.cg.hbm.service.interfaces.IPaymentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentService implements IPaymentService {
    @Override
    public Payments addPayment(Payments payment) {
        return null;
    }
}
