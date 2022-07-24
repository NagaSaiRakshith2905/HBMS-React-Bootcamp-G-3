package com.cg.hbm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.DatabaseMetaData;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int transaction_id;
    private double amount;
    private String transaction_date;


    public Transactions() {
    }

    public Transactions(double amount) {
        this.amount = amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
