package com.cg.hbm.pojo;

import java.sql.Date;
import java.util.List;

public class BookingDetailsPojo {
    private Date booked_from;
    private Date booked_to;
    private int no_of_adults;
    private int no_of_children;
    private double amount;
    private int hotel_id;//
    private List<Integer> room_id;//
    private int user_id;//

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

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public List<Integer> getRoom_id() {
        return room_id;
    }

    public void setRoom_id(List<Integer> room_id) {
        this.room_id = room_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
