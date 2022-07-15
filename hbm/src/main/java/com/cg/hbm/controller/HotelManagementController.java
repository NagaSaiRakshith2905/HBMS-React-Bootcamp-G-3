package com.cg.hbm.controller;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.service.classes.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/hotel/")
public class HotelManagementController {

    private HotelService hotelService;

    @Autowired
    public HotelManagementController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @PostMapping("add_hotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }
}
