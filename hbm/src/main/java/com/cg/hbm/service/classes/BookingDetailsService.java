package com.cg.hbm.service.classes;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.service.interfaces.IBookingDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingDetailsService implements IBookingDetailsService {
    @Override
    public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
        return null;
    }

    @Override
    public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
        return null;
    }

    @Override
    public BookingDetails removeBookingDetails(BookingDetails bookingDetails) {
        return null;
    }

    @Override
    public List<BookingDetails> showAllBookingDetails() {
        return null;
    }

    @Override
    public BookingDetails showBookingDetails(BookingDetails bookingDetails) {
        return null;
    }
}
