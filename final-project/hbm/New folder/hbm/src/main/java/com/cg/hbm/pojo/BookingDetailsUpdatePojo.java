package com.cg.hbm.pojo;

import java.sql.Date;

public class BookingDetailsUpdatePojo {

    private int booking_id;
    private Date booked_from;
    private Date booked_to;
    private int no_of_adults;
    private int no_of_children;
    private double amount;

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Date getBooked_from() {
        return booked_from;
    }

    public void setBooked_from(Date booked_from) {
        this.booked_from = booked_from;
    }

    public Date getBooked_to() {
        return booked_to;
    }

    public void setBooked_to(Date booked_to) {
        this.booked_to = booked_to;
    }

    public int getNo_of_adults() {
        return no_of_adults;
    }

    public void setNo_of_adults(int no_of_adults) {
        this.no_of_adults = no_of_adults;
    }

    public int getNo_of_children() {
        return no_of_children;
    }

    public void setNo_of_children(int no_of_children) {
        this.no_of_children = no_of_children;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
