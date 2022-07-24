package com.cg.hbm.controller;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.pojo.HotelUpdatePojo;
import com.cg.hbm.service.classes.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/hotel/")
@CrossOrigin(origins = "*")
public class HotelManagementController {

    @Autowired
    private HotelService hotelService;

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

    @PutMapping("update_hotel")
    public Hotel updateHotel(@RequestBody HotelUpdatePojo hotelUpdatePojo) {

        return hotelService.updateHotel(hotelUpdatePojo);
    }
}
