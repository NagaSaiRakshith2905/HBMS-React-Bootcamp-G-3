package com.cg.hbm.entities;

import javax.persistence.*;

import java.sql.Blob;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class RoomDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int room_id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private String room_no;
    private String room_type;
    private double rate_per_day;
    private boolean isAvailable;
//    private Blob photo;

    public RoomDetails() {
    }

    public RoomDetails(Hotel hotel, String room_no, String room_type, double rate_per_day, boolean isAvailable) {
        this.hotel = hotel;
        this.room_no = room_no;
        this.room_type = room_type;
        this.rate_per_day = rate_per_day;
        this.isAvailable = isAvailable;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public double getRate_per_day() {
        return rate_per_day;
    }

    public void setRate_per_day(double rate_per_day) {
        this.rate_per_day = rate_per_day;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}