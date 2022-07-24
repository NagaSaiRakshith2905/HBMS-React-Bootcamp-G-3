package com.cg.hbm.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int hotel_id;
    private String city;
    private String hotel_name;
    private String address;
    private String description;
    private double avg_rate_per_day;
    private String email;
    private String phone1;
    private String phone2;
    private String website;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<RoomDetails> roomDetailsList = new ArrayList<>();

    public Hotel(String city, String hotel_name, String address, String description, double avg_rate_per_day, String email, String phone1, String phone2, String website) {
        this.city = city;
        this.hotel_name = hotel_name;
        this.address = address;
        this.description = description;
        this.avg_rate_per_day = avg_rate_per_day;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.website = website;
    }

    public Hotel(String city, String hotel_name, String address, String description, double avg_rate_per_day, String email, String phone1, String phone2, String website, List<RoomDetails> roomDetailsList) {
        this.city = city;
        this.hotel_name = hotel_name;
        this.address = address;
        this.description = description;
        this.avg_rate_per_day = avg_rate_per_day;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.website = website;
        this.roomDetailsList = roomDetailsList;
    }

    public Hotel() {

    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvg_rate_per_day() {
        return avg_rate_per_day;
    }

    public void setAvg_rate_per_day(double avg_rate_per_day) {
        this.avg_rate_per_day = avg_rate_per_day;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<RoomDetails> getRoomDetailsList() {
        return roomDetailsList;
    }

    public void setRoomDetailsList(List<RoomDetails> roomDetailsList) {
        this.roomDetailsList = roomDetailsList;
    }
}
