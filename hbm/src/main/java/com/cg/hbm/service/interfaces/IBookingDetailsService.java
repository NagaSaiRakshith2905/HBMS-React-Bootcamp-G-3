package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.BookingDetails;

import java.util.List;

public interface IBookingDetailsService {
    public BookingDetails addBookingDetails(BookingDetails bookingDetails);
    public BookingDetails updateBookingDetails(BookingDetails bookingDetails);
    public BookingDetails removeBookingDetails(BookingDetails bookingDetails);
    public List<BookingDetails> showAllBookingDetails();
    public BookingDetails showBookingDetails(BookingDetails bookingDetails);
}
