package com.cg.hbm.controller;

import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.service.classes.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/room/")
public class RoomManagementController {

    private RoomDetailsService service;

    @Autowired
    public RoomManagementController(RoomDetailsService service) {
        this.service = service;
    }

    @PostMapping("add")
    public RoomDetails add_room(@RequestBody RoomDetailsPojo roomDetails) {
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

    @DeleteMapping("remove_room_details")
    public void removeRoomDetails(@RequestParam("roomDetails_id") int roomDetails_id) {
        service.removeRoomDetails(roomDetails_id);
    }
    @PutMapping("update_room_details")
    public RoomDetails updateRoomDetails(@RequestBody RoomDetailsPojo roomDetailsPojo) {
        return service.updateRoomDetails(roomDetailsPojo);
    }
}
