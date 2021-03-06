package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.exception_handler.HotelNotFoundException;
import com.cg.hbm.exception_handler.RoomDetailsNotFoundException;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.pojo.RoomDetailsUpdatePojo;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.service.interfaces.IRoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class RoomDetailsService implements IRoomDetailsService {

    @Autowired
    RoomDetailsRepository roomDetailsRepository;


    @Override
    public RoomDetails addRoomDetails(RoomDetails roomDetails) {
        return roomDetailsRepository.save(roomDetails);
    }

    @Override
    public RoomDetails updateRoomDetails(RoomDetailsUpdatePojo roomDetailsUpdatePojo) {
        Optional<RoomDetails> roomDetails = roomDetailsRepository.findbyId(roomDetailsUpdatePojo.getRoom_id());

        if (roomDetails.isEmpty()) {
            throw new RoomDetailsNotFoundException("Room with id " + roomDetailsUpdatePojo.getRoom_id() + " does not Exist");
        }
        if (roomDetailsUpdatePojo.getRoom_no() != null && roomDetailsUpdatePojo.getRoom_no().length() > 0 && !Objects.equals(roomDetails.get().getRoom_no(), roomDetailsUpdatePojo.getRoom_no())) {
            roomDetails.get().setRoom_no(roomDetailsUpdatePojo.getRoom_no());
        }
        if (roomDetailsUpdatePojo.getRoom_type() != null && roomDetailsUpdatePojo.getRoom_type().length() > 0 && !Objects.equals(roomDetails.get().getRoom_type(), roomDetailsUpdatePojo.getRoom_type())) {
            roomDetails.get().setRoom_type(roomDetailsUpdatePojo.getRoom_type());
        }
        if (roomDetailsUpdatePojo.getPhoto() != null && roomDetailsUpdatePojo.getPhoto().length() > 0 && !Objects.equals(roomDetails.get().getPhoto(), roomDetailsUpdatePojo.getPhoto())) {
            roomDetails.get().setPhoto(roomDetailsUpdatePojo.getPhoto());
        }
        if (roomDetailsUpdatePojo.getRate_per_day() > 0 && roomDetails.get().getRate_per_day() != roomDetailsUpdatePojo.getRate_per_day()) {
            roomDetails.get().setRate_per_day(roomDetailsUpdatePojo.getRate_per_day());
        }
        return roomDetails.get();
    }

    @Override
    public void removeRoomDetails(int roomDetails_id) {
        Optional<RoomDetails> optionalRoomDetails = roomDetailsRepository.findById(roomDetails_id);
        if (optionalRoomDetails.isEmpty())
            throw new HotelNotFoundException("Hotel with id:" + roomDetails_id + " not found ");
        roomDetailsRepository.deleteById(roomDetails_id);
    }

    @Override
    public List<RoomDetails> showAllRoomDetails() {
        return roomDetailsRepository.findAll();
    }

    @Override
    public RoomDetails showRoomDetails(int roomDetails_id) {
        Optional<RoomDetails> optionalRoomDetails = roomDetailsRepository.findById(roomDetails_id);
        if (optionalRoomDetails.isEmpty())
            throw new RoomDetailsNotFoundException("Room with id:" + roomDetails_id + " not found ");
        return optionalRoomDetails.get();
    }
}
