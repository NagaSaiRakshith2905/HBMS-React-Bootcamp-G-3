package com.cg.hbm.controller;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.exception_handler.HotelNotFoundException;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.pojo.RoomDetailsUpdatePojo;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.service.classes.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/room/")
@CrossOrigin(origins = "*")
public class RoomManagementController {

    private RoomDetailsService service;
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    public RoomManagementController(RoomDetailsService service) {
        this.service = service;
    }

    @PostMapping("add_room/")
    public RoomDetails add_room(@RequestBody RoomDetailsPojo roomDetailsPojo) {
        Optional<Hotel> hotel1 = hotelRepository.findById(roomDetailsPojo.getHotel_id());
        if (hotel1.isEmpty())
            throw new HotelNotFoundException("Hotel not found");

        RoomDetails roomDetails = new RoomDetails(hotel1.get(), roomDetailsPojo.getRoom_no(), roomDetailsPojo.getRoom_type(), roomDetailsPojo.getRate_per_day(), roomDetailsPojo.isAvailable(), roomDetailsPojo.getPhoto());

        return service.addRoomDetails(roomDetails);
    }

    @GetMapping("view_room_details/")
    public RoomDetails showRoomDetails(@RequestParam int roomDetails_id) {
        return service.showRoomDetails(roomDetails_id);
    }
    @GetMapping("view_all_room_details/")
    public List<RoomDetails> showAllRoomDetails() {
        return service.showAllRoomDetails();
    }

    @DeleteMapping("remove_room_details/")
    public void removeRoomDetails(@RequestParam("roomDetails_id") int roomDetails_id) {
        service.removeRoomDetails(roomDetails_id);
    }
    @PutMapping("update_room_details/")
    public RoomDetails updateRoomDetails(@RequestBody RoomDetailsUpdatePojo roomDetailsUpdatePojo) {
        return service.updateRoomDetails(roomDetailsUpdatePojo);
    }
}
