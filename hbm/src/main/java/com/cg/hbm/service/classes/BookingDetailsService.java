package com.cg.hbm.service.classes;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.HotelNotFoundException;
import com.cg.hbm.exception_handler.RoomDetailsNotFoundException;
import com.cg.hbm.exception_handler.UserNotFoundException;
import com.cg.hbm.pojo.BookingDetailsPojo;
import com.cg.hbm.repository.BookingDetailsRepository;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IBookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingDetailsService implements IBookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    private RoomDetailsRepository roomDetailsRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public BookingDetails addBookingDetails(BookingDetailsPojo bookingDetailsPojo) {
        Optional<Hotel> hotel = hotelRepository.findById(bookingDetailsPojo.getHotel_id());
        if (hotel.isEmpty())
            throw new HotelNotFoundException("Hotel not found");
        Optional<UserDetails> user = userRepository.findById(bookingDetailsPojo.getUser_id());
        if (user.isEmpty())
            throw new UserNotFoundException("User not found");
        BookingDetails bookingDetails = new BookingDetails(bookingDetailsPojo.getBooked_from(), bookingDetailsPojo.getBooked_to(), bookingDetailsPojo.getNo_of_adults(), bookingDetailsPojo.getNo_of_children(), bookingDetailsPojo.getAmount(), hotel.get(), user.get());
        BookingDetails details = bookingDetailsRepository.save(bookingDetails);
        for (int id : bookingDetailsPojo.getRoom_id()) {
            Optional<RoomDetails> roomDetails = roomDetailsRepository.findById(id);
            if (roomDetails.isEmpty())
                throw new RoomDetailsNotFoundException("Room not found");
            roomDetails.get().setBookingDetails(details);
            roomDetails.get().setAvailable(false);
        }
        return details;
    }

    @Override
    public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
        return null;
    }

    @Override
    public void removeBookingDetails(int id) {
        Optional<BookingDetails> bookingDetails = bookingDetailsRepository.findById(id);
        if (bookingDetails.isEmpty())
            throw new IllegalStateException("booking details not found");
        List<RoomDetails> roomDetails = bookingDetails.get().getRoomDetails();
        for (RoomDetails room : roomDetails) {
            Optional<RoomDetails> optional = roomDetailsRepository.findById(room.getRoom_id());
            optional.get().setAvailable(true);
        }
        bookingDetailsRepository.deleteById(id);
    }

    @Override
    public List<BookingDetails> showAllBookingDetails() {
        return bookingDetailsRepository.findAll();
    }

    @Override
    public BookingDetails showBookingDetails(int id) {
        Optional<BookingDetails> bookingDetails = bookingDetailsRepository.findById(id);
        if (bookingDetails.isEmpty())
            throw new IllegalStateException("booking details not found of ID:" + id);
        return bookingDetails.get();
    }

}
