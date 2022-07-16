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

    private HotelRepository repository;

    @Autowired
    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }
    @Override
    public Hotel addHotel(Hotel hotel) {
        return repository.save(hotel);
    }
    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }
    @Override
    public void removeHotel(int id) {
        repository.deleteById(id);
    }
    @Override
    public List<Hotel> showAllHotels() {
        return repository.findAll();
    }
    @Override
    public Hotel showHotel(int id) {
        Optional<Hotel> hotel = repository.findById(id);
        if (hotel.isPresent())
            return hotel.get();
        else
            throw new IllegalStateException("hotel does not exist");
    }
}
