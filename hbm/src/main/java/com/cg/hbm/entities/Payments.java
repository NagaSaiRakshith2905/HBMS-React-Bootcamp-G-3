package com.cg.hbm.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int payment_id;

    @ManyToOne
    @JoinColumn(name="booking_id")
    private BookingDetails bookingDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transactions transactions;

    public Payments() {
    }

    public Payments(BookingDetails bookingDetails, Transactions transactions) {
        this.bookingDetails = bookingDetails;
        this.transactions = transactions;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
}
