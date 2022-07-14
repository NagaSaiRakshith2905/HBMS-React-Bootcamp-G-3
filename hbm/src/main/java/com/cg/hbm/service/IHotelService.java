package com.cg.hbm.service;

import com.cg.hbm.entities.Hotel;

import java.util.List;

public interface IHotelService {
    public Hotel addHotel(Hotel hotel);
    public Hotel updateHotel(Hotel hotel);
    public Hotel removeHotel(Hotel hotel);
    public List<Hotel> showAllHotels();
    public Hotel showHotel(Hotel id);
}
