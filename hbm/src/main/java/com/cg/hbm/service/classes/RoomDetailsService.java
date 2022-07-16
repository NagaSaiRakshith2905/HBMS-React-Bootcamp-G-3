package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.service.interfaces.IRoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomDetailsService implements IRoomDetailsService {

    @Autowired
    RoomDetailsRepository roomDetailsRepository;
    @Autowired
    HotelRepository hotelRepository;


    @Override
    public RoomDetails addRoomDetails(RoomDetailsPojo roomDetailsPojo) {

        Optional<Hotel> hotel1 = hotelRepository.findById(roomDetailsPojo.getHotel_id());
        if (hotel1.isEmpty())
            throw new IllegalStateException("Hotel not found");

        RoomDetails roomDetails = new RoomDetails(hotel1.get(), roomDetailsPojo.getRoom_no(), roomDetailsPojo.getRoom_type(), roomDetailsPojo.getRate_per_day(), roomDetailsPojo.isAvailable(), roomDetailsPojo.getPhoto());

        return roomDetailsRepository.save(roomDetails);
    }

    @Override
    public RoomDetails updateRoomDetails(RoomDetailsPojo roomDetailsPojo) {
        Optional<RoomDetails> optionalRoomDetails = roomDetailsRepository.findById(roomDetailsPojo.getRoom_id());
        if(optionalRoomDetails.isEmpty())
            throw new IllegalStateException("Hotel with id:"+ roomDetailsPojo.getRoom_id()+" not found ");
        RoomDetails roomDetails = new RoomDetails(optionalRoomDetails.get().getHotel(), roomDetailsPojo.getRoom_no(), roomDetailsPojo.getRoom_type(), roomDetailsPojo.getRate_per_day(), roomDetailsPojo.isAvailable(), roomDetailsPojo.getPhoto());
        return roomDetailsRepository.save(roomDetails);
    }

    @Override
    public void removeRoomDetails(int roomDetails_id) {
        Optional<RoomDetails> optionalRoomDetails = roomDetailsRepository.findById(roomDetails_id);
        if(optionalRoomDetails.isEmpty())
            throw new IllegalStateException("Hotel with id:"+ roomDetails_id+" not found ");
        roomDetailsRepository.deleteById(roomDetails_id);
    }

    @Override
    public List<RoomDetails> showAllRoomDetails() {
        return roomDetailsRepository.findAll();
    }

    @Override
    public RoomDetails showRoomDetails(int roomDetails_id) {
        Optional<RoomDetails> optionalRoomDetails = roomDetailsRepository.findById(roomDetails_id);
        if(optionalRoomDetails.isEmpty())
            throw new IllegalStateException("Hotel with id:"+ roomDetails_id+" not found ");
        System.out.println(optionalRoomDetails.get().getHotel().getHotel_id());
        return optionalRoomDetails.get();
    }
}
