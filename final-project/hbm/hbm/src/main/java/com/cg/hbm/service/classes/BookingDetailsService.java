package com.cg.hbm.service.classes;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.exception_handler.BookingDetailsNotFoundException;
import com.cg.hbm.pojo.BookingDetailsUpdatePojo;
import com.cg.hbm.repository.BookingDetailsRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.service.interfaces.IBookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class BookingDetailsService implements IBookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    private RoomDetailsRepository roomDetailsRepository;



    @Override
    public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
        return    bookingDetailsRepository.save(bookingDetails);
    }

    @Override
    public BookingDetails updateBookingDetails(BookingDetailsUpdatePojo bookingDetailsUpdatePojo) {

        Optional<BookingDetails> bookingDetails = bookingDetailsRepository.findById(bookingDetailsUpdatePojo.getBooking_id());
        if (bookingDetails.isEmpty()) {
            throw new BookingDetailsNotFoundException("Booking with id " + bookingDetailsUpdatePojo.getBooking_id() + " does not Exist");
        }
        if (bookingDetailsUpdatePojo.getBooked_to() != null && !Objects.equals(bookingDetails.get().getBooked_to(), bookingDetailsUpdatePojo.getBooked_to())) {
            bookingDetails.get().setBooked_to(bookingDetailsUpdatePojo.getBooked_to());
        }

        if (bookingDetailsUpdatePojo.getBooked_from() != null && !Objects.equals(bookingDetails.get().getBooked_from(), bookingDetailsUpdatePojo.getBooked_from())) {
            bookingDetails.get().setBooked_from(bookingDetailsUpdatePojo.getBooked_from());
        }

        if (bookingDetailsUpdatePojo.getNo_of_adults() > 0 && !Objects.equals(bookingDetails.get().getNo_of_adults(), bookingDetailsUpdatePojo.getNo_of_adults())) {
            bookingDetails.get().setNo_of_adults(bookingDetailsUpdatePojo.getNo_of_adults());
        }

        if (bookingDetailsUpdatePojo.getNo_of_children() > 0 && !Objects.equals(bookingDetails.get().getNo_of_children(), bookingDetailsUpdatePojo.getNo_of_children())) {
            bookingDetails.get().setNo_of_children(bookingDetailsUpdatePojo.getNo_of_children());
        }

        if (bookingDetailsUpdatePojo.getAmount() > 0 && !Objects.equals(bookingDetails.get().getAmount(), bookingDetailsUpdatePojo.getAmount())) {
            bookingDetails.get().setAmount(bookingDetailsUpdatePojo.getAmount());
        }

        return bookingDetails.get();

    }

    @Override
    public void removeBookingDetails(int id) {
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
            throw new BookingDetailsNotFoundException("booking details not found of ID:" + id);
        return bookingDetails.get();
    }

}
