package com.cg.hbm.service.classes;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Payments;
import com.cg.hbm.entities.Transactions;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.pojo.PaymentPojo;
import com.cg.hbm.repository.PaymentRepository;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IPaymentService;
import com.cg.hbm.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest

class PaymentServiceTest {
    @InjectMocks
    private IPaymentService paymentService = new PaymentService();

    @Mock
    private PaymentRepository paymentRepository;

    @Test
    void addPayment() {
        Payments payments = new Payments();
        int payment_id = 51;
        payments.setPayment_id(payment_id);
        BookingDetails bookingDetails = new BookingDetails();

        int booking_id = 31;
        bookingDetails.setBooking_id(booking_id);
        payments.setBookingDetails(bookingDetails);
        Transactions transactions = new Transactions();
        int transaction_id = 41;
        transactions.setTransaction_id(transaction_id);
        transactions.setTransaction_date("2022-07-18");
        transactions.setAmount(4000);
        payments.setTransactions(transactions);



        when(paymentRepository.save(payments)).thenReturn(payments);

        Payments newpayment = paymentService.addPayment(payments);

        assertThat(newpayment.getBookingDetails().getBooking_id()).isEqualTo(booking_id);
        assertThat(newpayment.getTransactions().getTransaction_id()).isEqualTo(transaction_id);
    }

    @Test
    void viewPayment() {
        Payments payments = new Payments();
        int payment_id = 51;
        payments.setPayment_id(payment_id);
        BookingDetails bookingDetails = new BookingDetails();

        int booking_id = 31;
        bookingDetails.setBooking_id(booking_id);
        payments.setBookingDetails(bookingDetails);
        Transactions transactions = new Transactions();
        int transaction_id = 41;
        transactions.setTransaction_id(transaction_id);
        transactions.setTransaction_date("2022-07-18");
        transactions.setAmount(4000);
        payments.setTransactions(transactions);


        when(paymentRepository.findById(payment_id)).thenReturn(Optional.of(payments));
        PaymentPojo newpayment = paymentService.viewPayment(payment_id);

        assertThat(newpayment.getBooking_id()).isEqualTo(booking_id);
        assertThat(newpayment.getTransaction_id()).isEqualTo(transaction_id);

    }

    @Test
    void viewAllPayment() {
        Payments payments1 = new Payments();
        int payment_id = 51;
        payments1.setPayment_id(payment_id);

        BookingDetails bookingDetails1 = new BookingDetails();
        int booking_id = 31;
        bookingDetails1.setBooking_id(booking_id);
        payments1.setBookingDetails(bookingDetails1);

        Transactions transactions = new Transactions();
        int transaction_id = 41;
        transactions.setTransaction_id(transaction_id);
        transactions.setTransaction_date("2022-07-18");
        transactions.setAmount(4000);
        payments1.setTransactions(transactions);


        Payments payments2 =new Payments();
        int payment_id2 = 52;
        payments2.setPayment_id(payment_id2);

        BookingDetails bookingDetails2 = new BookingDetails();
        int booking_id2 = 32;
        bookingDetails2.setBooking_id(booking_id2);
        payments2.setBookingDetails(bookingDetails2);

        Transactions transactions2 = new Transactions();
        int transaction_id2 = 42;
        transactions2.setTransaction_id(transaction_id2);
        transactions2.setTransaction_date("2022-07-19");
        transactions2.setAmount(5000);
        payments2.setTransactions(transactions2);



        Payments payments3 = new Payments();
        int payment_id3 = 53;
        payments3.setPayment_id(payment_id3);

        BookingDetails bookingDetails3 = new BookingDetails();
        int booking_id3 = 33;
        bookingDetails3.setBooking_id(booking_id3);
        payments3.setBookingDetails(bookingDetails3);

        Transactions transactions3 = new Transactions();
        int transaction_id3 = 43;
        transactions3.setTransaction_id(transaction_id3);
        transactions3.setTransaction_date("2022-07-20");
        transactions3.setAmount(6000);
        payments3.setTransactions(transactions3);


        List<Payments> list = new ArrayList<>();
        list.add(payments1);
        list.add(payments2);
        list.add(payments3);
        when(paymentRepository.findAll()).thenReturn(list);

        List<PaymentPojo> paymentsList = paymentService.viewAllPayment();

        assertThat(paymentsList.size()).isEqualTo(3);


    }
}