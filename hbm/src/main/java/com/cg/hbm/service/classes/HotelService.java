package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.service.interfaces.IHotelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelService implements IHotelService {
    @Override
    public Hotel addHotel(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel removeHotel(Hotel hotel) {
        return null;
    }

    @Override
    public List<Hotel> showAllHotels() {
        return null;
    }

    @Override
    public Hotel showHotel(Hotel id) {
        return null;
    }
}
