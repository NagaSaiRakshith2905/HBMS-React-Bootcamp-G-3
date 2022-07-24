package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.pojo.BookingDetailsUpdatePojo;

import java.util.List;

public interface IBookingDetailsService {
    public BookingDetails addBookingDetails(BookingDetails bookingDetails);
    public BookingDetails updateBookingDetails(BookingDetailsUpdatePojo bookingDetailsUpdatePojo);
    public void removeBookingDetails(int id);
    public List<BookingDetails> showAllBookingDetails();
    public BookingDetails showBookingDetails(int id);
}
