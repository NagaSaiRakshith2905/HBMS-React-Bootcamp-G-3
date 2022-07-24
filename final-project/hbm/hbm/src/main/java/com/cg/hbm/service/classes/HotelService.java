package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.exception_handler.HotelNotFoundException;
import com.cg.hbm.pojo.HotelUpdatePojo;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.service.interfaces.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
    public Hotel updateHotel(HotelUpdatePojo hotelUpdatePojo) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelUpdatePojo.getHotel_id());

        if (hotel.isEmpty()) {
            throw new HotelNotFoundException("Hotel with id " + hotelUpdatePojo.getHotel_id() + " does not Exist");
        }


        if(hotelUpdatePojo.getCity() != null && hotelUpdatePojo.getCity().length() > 0 && !Objects.equals(hotel.get().getCity(),hotelUpdatePojo.getCity())){
            hotel.get().setCity(hotelUpdatePojo.getCity());
        }

        if(hotelUpdatePojo.getHotel_name() != null && hotelUpdatePojo.getHotel_name().length() > 0 && !Objects.equals(hotel.get().getHotel_name(),hotelUpdatePojo.getHotel_name())) {
            hotel.get().setHotel_name(hotelUpdatePojo.getHotel_name());

        }

        if(hotelUpdatePojo.getAddress() != null && hotelUpdatePojo.getAddress().length() > 0 && !Objects.equals(hotel.get().getAddress(),hotelUpdatePojo.getAddress())) {
            hotel.get().setAddress(hotelUpdatePojo.getAddress());
        }

        if(hotelUpdatePojo.getDescription() != null && hotelUpdatePojo.getDescription().length() > 0 && !Objects.equals(hotel.get().getDescription(),hotelUpdatePojo.getDescription())) {
            hotel.get().setDescription(hotelUpdatePojo.getDescription());
        }

        if(hotelUpdatePojo.getAvg_rate_per_day() > 0 && !Objects.equals(hotel.get().getAvg_rate_per_day(),hotelUpdatePojo.getAvg_rate_per_day())){
            hotel.get().setAvg_rate_per_day(hotelUpdatePojo.getAvg_rate_per_day());
        }

        if(hotelUpdatePojo.getEmail() != null && hotelUpdatePojo.getEmail().length() > 0 && !Objects.equals(hotel.get().getEmail(),hotelUpdatePojo.getEmail())) {
            hotel.get().setEmail(hotelUpdatePojo.getEmail());
        }

        if(hotelUpdatePojo.getPhone1() != null && hotelUpdatePojo.getPhone1().length() > 0 && !Objects.equals(hotel.get().getPhone1(),hotelUpdatePojo.getPhone1())) {
            hotel.get().setPhone1(hotelUpdatePojo.getPhone1());
        }

        if(hotelUpdatePojo.getPhone2() != null && hotelUpdatePojo.getPhone2().length() > 0 && !Objects.equals(hotel.get().getPhone2(),hotelUpdatePojo.getPhone2())) {
            hotel.get().setPhone2(hotelUpdatePojo.getPhone2());
        }

        if(hotelUpdatePojo.getWebsite() != null && hotelUpdatePojo.getWebsite().length() > 0 && !Objects.equals(hotel.get().getWebsite(),hotelUpdatePojo.getWebsite())) {
            hotel.get().setWebsite(hotelUpdatePojo.getWebsite());
        }

        return hotel.get();
    }
    @Override
    public void removeHotel(int id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if(optionalHotel.isEmpty())
            throw new HotelNotFoundException("Hotel with id:"+ id+" not found ");
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
            throw new HotelNotFoundException("Hotel with id:"+ id+" not found ");
        return optionalHotel.get();
    }
}
