package com.cg.hbm.controller;

import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.service.classes.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/room/")
public class RoomManagementController {

    private RoomDetailsService service;

    @Autowired
    public RoomManagementController(RoomDetailsService service) {
        this.service = service;
    }

    @PostMapping("add")
    public RoomDetails add_room(@RequestBody RoomDetailsPojo roomDetails){
//        System.out.println(roomDetails.);
        return service.addRoomDetails(roomDetails);
    }
}
