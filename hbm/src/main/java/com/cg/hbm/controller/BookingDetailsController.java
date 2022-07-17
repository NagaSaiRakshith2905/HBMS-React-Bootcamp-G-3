package com.cg.hbm.controller;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.pojo.BookingDetailsPojo;
import com.cg.hbm.service.classes.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/booking/")
public class BookingDetailsController {
    @Autowired
    private BookingDetailsService bookingDetailsService;

    @PostMapping("add_booking_details/")
    public BookingDetails addBookingDetails(BookingDetailsPojo bookingDetailsPojo) {
        return bookingDetailsService.addBookingDetails(bookingDetailsPojo);
    }
    @GetMapping("view_booking_details/")
    public BookingDetails showBookingDetails(@RequestParam("booking_id") int id) {
        return bookingDetailsService.showBookingDetails(id);
    }

    @GetMapping("view_all_booking_details/")
    public List<BookingDetails> showAllBookingDetails() {
        return bookingDetailsService.showAllBookingDetails();
    }

    @DeleteMapping("remove_booking_details/")
    public void removeBookingDetails(@RequestParam("booking_id") int id) {
        bookingDetailsService.removeBookingDetails(id);
    }
}
