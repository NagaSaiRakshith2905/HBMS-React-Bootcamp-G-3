package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.Hotel;

import java.util.List;

public interface IHotelService {
    public Hotel addHotel(Hotel hotel);
    public Hotel updateHotel(Hotel hotel);
    public void removeHotel(int id);
    public List<Hotel> showAllHotels();
    public Hotel showHotel(int id);
}
