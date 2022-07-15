package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.service.interfaces.IHotelService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelService implements IHotelService {

    private HotelRepository repository;

    @Autowired
    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
//        if (hotel.getAddress().toString()==null || hotel.getHotel_name().toString()==null ||hotel.getCity().toString()==null ||hotel.getAvg_rate_per_day()>=0 ||hotel.getDescription().toString()==null ||hotel.getEmail().toString()==null ||hotel.getPhone1().toString()==null ||hotel.getPhone2().toString()==null || hotel.getWebsite().toString()==null ){
//            throw new IllegalStateException("No null values");
//        }
        System.out.println(hotel);
//        R repository1 = repository.findBy(hotel.getHotel_id());
        return repository.save(hotel);
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
