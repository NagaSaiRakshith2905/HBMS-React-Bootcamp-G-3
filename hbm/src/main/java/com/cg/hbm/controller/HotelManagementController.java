package com.cg.hbm.controller;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.service.classes.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/hotel/")
public class HotelManagementController {

    private HotelService hotelService;

    @Autowired
    public HotelManagementController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("add_hotel/")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @GetMapping("view_hotel/")
    public Hotel showHotel(@RequestParam("hotel_id") int id) {
        return hotelService.showHotel(id);
    }

    @GetMapping("view_all/")
    public List<Hotel> showAllHotels() {
        return hotelService.showAllHotels();
    }

    @DeleteMapping("remove_hotel")
    public void removeHotel(@RequestParam("hotel_id") int id) {
        hotelService.removeHotel(id);
    }
}
