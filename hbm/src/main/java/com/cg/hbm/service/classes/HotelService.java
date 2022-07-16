package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelService implements IHotelService {

    @Autowired private HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    @Override
    public Hotel updateHotel(Hotel hotel) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotel.getHotel_id());
        if(optionalHotel.isEmpty())
            throw new IllegalStateException("Hotel with id:"+ hotel.getHotel_id()+" not found ");
        return hotelRepository.save(hotel);
    }
    @Override
    public void removeHotel(int id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if(optionalHotel.isEmpty())
            throw new IllegalStateException("Hotel with id:"+ id+" not found ");
        hotelRepository.deleteById(id);
    }
    @Override
    public List<Hotel> showAllHotels() {
        return hotelRepository.findAll();
    }
    @Override
    public Hotel showHotel(int id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if(optionalHotel.isEmpty())
            throw new IllegalStateException("Hotel with id:"+ id+" not found ");
        return optionalHotel.get();
    }
}
