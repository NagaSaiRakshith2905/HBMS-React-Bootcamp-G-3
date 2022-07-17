package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.pojo.BookingDetailsPojo;

import java.util.List;

public interface IBookingDetailsService {
    public BookingDetails addBookingDetails(BookingDetailsPojo bookingDetailsPojo);
    public BookingDetails updateBookingDetails(BookingDetails bookingDetails);
    public void removeBookingDetails(int id);
    public List<BookingDetails> showAllBookingDetails();
    public BookingDetails showBookingDetails(int id);
}
