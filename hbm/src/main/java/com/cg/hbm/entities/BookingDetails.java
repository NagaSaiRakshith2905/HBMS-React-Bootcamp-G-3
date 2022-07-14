package com.cg.hbm.entities;

import javax.persistence.*;

import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int booking_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomDetails roomDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDetails user;

    private Date booked_from;
    private Date booked_to;
    private int no_of_adults;
    private int no_of_children;
    private double amount;

    public BookingDetails() {
    }

    public BookingDetails(Hotel hotel, RoomDetails roomDetails, UserDetails user, Date booked_from, Date booked_to, int no_of_adults, int no_of_children, double amount) {
        this.hotel = hotel;
        this.roomDetails = roomDetails;
        this.user = user;
        this.booked_from = booked_from;
        this.booked_to = booked_to;
        this.no_of_adults = no_of_adults;
        this.no_of_children = no_of_children;
        this.amount = amount;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(RoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
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
