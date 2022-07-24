package com.cg.hbm.pojo;

public class RoomDetailsPojo {
//    private int room_id;
    private String room_no;
    private String room_type;
    private double rate_per_day;
    private boolean isAvailable;
    private String photo;
    private int hotel_id;

//    public int getRoom_id() {
//        return room_id;
//    }
//
//    public void setRoom_id(int room_id) {
//        this.room_id = room_id;
//    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
}
