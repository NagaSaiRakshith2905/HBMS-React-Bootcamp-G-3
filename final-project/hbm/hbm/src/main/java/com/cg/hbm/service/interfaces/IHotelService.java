package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.pojo.HotelUpdatePojo;

import java.util.List;

public interface IHotelService {
    public Hotel addHotel(Hotel hotel);
    public Hotel updateHotel(HotelUpdatePojo hotelUpdatePojo);
    public void removeHotel(int id);
    public List<Hotel> showAllHotels();
    public Hotel showHotel(int id);
}
