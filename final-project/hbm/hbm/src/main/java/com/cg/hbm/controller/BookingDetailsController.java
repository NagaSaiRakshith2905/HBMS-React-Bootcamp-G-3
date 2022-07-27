package com.cg.hbm.controller;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.BookingDetailsNotFoundException;
import com.cg.hbm.exception_handler.HotelNotFoundException;
import com.cg.hbm.exception_handler.RoomDetailsNotFoundException;
import com.cg.hbm.exception_handler.UserNotFoundException;
import com.cg.hbm.pojo.BookingDetailsPojo;
import com.cg.hbm.pojo.BookingDetailsUpdatePojo;
import com.cg.hbm.repository.BookingDetailsRepository;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.classes.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/booking/")
@CrossOrigin(origins = "http://localhost:3000/")
@Transactional
public class BookingDetailsController {
    @Autowired
    private BookingDetailsService bookingDetailsService;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomDetailsRepository roomDetailsRepository;

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @PostMapping("add_booking_details/")
    @Transactional
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
        Optional<BookingDetails> bookingDetails = bookingDetailsRepository.findById(id);
        if (bookingDetails.isEmpty())
            throw new BookingDetailsNotFoundException("booking details not found");
        List<RoomDetails> roomDetails = bookingDetails.get().getRoomDetails();
        List<RoomDetails> saveRoomList = new ArrayList<>();
        for (RoomDetails room : roomDetails) {
            Optional<RoomDetails> optional = roomDetailsRepository.findById(room.getRoom_id());
            RoomDetails r_details = new RoomDetails(optional.get().getRoom_id(),optional.get().getRoom_no(),optional.get().getRoom_type(),optional.get().getRate_per_day(),true,optional.get().getPhoto(),optional.get().getHotel());
            saveRoomList.add(r_details);
        };
        bookingDetailsService.removeBookingDetails(id);
        roomDetailsRepository.saveAll(saveRoomList);
    }

    @PutMapping("update_booking_details/")
    public BookingDetails updateBookingDetails(@RequestBody BookingDetailsUpdatePojo bookingDetailsUpdatePojo) {
        return bookingDetailsService.updateBookingDetails(bookingDetailsUpdatePojo);
    }
}
