package com.cg.hbm.controller;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.HotelNotFoundException;
import com.cg.hbm.exception_handler.RoomDetailsNotFoundException;
import com.cg.hbm.exception_handler.UserNotFoundException;
import com.cg.hbm.pojo.BookingDetailsPojo;
import com.cg.hbm.pojo.BookingDetailsUpdatePojo;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.classes.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/booking/")
@CrossOrigin(origins = "*")
public class BookingDetailsController {
    @Autowired
    private BookingDetailsService bookingDetailsService;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomDetailsRepository roomDetailsRepository;

    @PostMapping("add_booking_details/")
    public BookingDetails addBookingDetails(@RequestBody BookingDetailsPojo bookingDetailsPojo) {
        Optional<Hotel> hotel = hotelRepository.findById(bookingDetailsPojo.getHotel_id());
        if (hotel.isEmpty())
            throw new HotelNotFoundException("Hotel not found");
        Optional<UserDetails> user = userRepository.findById(bookingDetailsPojo.getUser_id());
        if (user.isEmpty())
            throw new UserNotFoundException("User not found");
        BookingDetails bookingDetails = new BookingDetails(bookingDetailsPojo.getBooked_from(), bookingDetailsPojo.getBooked_to(), bookingDetailsPojo.getNo_of_adults(), bookingDetailsPojo.getNo_of_children(), bookingDetailsPojo.getAmount(), hotel.get(), user.get());

        BookingDetails details = bookingDetailsService.addBookingDetails(bookingDetails);

        for (int id : bookingDetailsPojo.getRoom_id()) {
            Optional<RoomDetails> roomDetails = roomDetailsRepository.findById(id);
            if (roomDetails.isEmpty())
                throw new RoomDetailsNotFoundException("Room not found");
            roomDetails.get().setBookingDetails(details);
            roomDetails.get().setAvailable(false);
        }
        return details;
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

    @PutMapping("update_booking_details/")
    public BookingDetails updateBookingDetails(@RequestBody BookingDetailsUpdatePojo bookingDetailsUpdatePojo) {
        return bookingDetailsService.updateBookingDetails(bookingDetailsUpdatePojo);
    }
}
