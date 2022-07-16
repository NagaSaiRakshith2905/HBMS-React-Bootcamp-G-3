package com.cg.hbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int booking_id;
    private Date booked_from;
    private Date booked_to;
    private int no_of_adults;
    private int no_of_children;
    private double amount;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @JsonIgnore
    @OneToMany(mappedBy = "bookingDetails",cascade = CascadeType.ALL)
    private List<RoomDetails> roomDetails = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;

    @JsonIgnore
    @OneToMany(mappedBy = "bookingDetails",cascade = CascadeType.ALL)
    private List<Payments> payments = new ArrayList<>();

    public BookingDetails() {
    }

    public BookingDetails(Date booked_from, Date booked_to, int no_of_adults, int no_of_children, double amount, Hotel hotel, List<RoomDetails> roomDetails, UserDetails user, List<Payments> payments) {
        this.booked_from = booked_from;
        this.booked_to = booked_to;
        this.no_of_adults = no_of_adults;
        this.no_of_children = no_of_children;
        this.amount = amount;
        this.hotel = hotel;
        this.roomDetails = roomDetails;
        this.user = user;
        this.payments = payments;
    }

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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }
}
