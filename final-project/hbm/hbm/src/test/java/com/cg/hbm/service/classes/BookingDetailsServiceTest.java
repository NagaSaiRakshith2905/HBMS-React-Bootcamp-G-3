package com.cg.hbm.service.classes;

import com.cg.hbm.entities.BookingDetails;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.BookingDetailsNotFoundException;
import com.cg.hbm.repository.BookingDetailsRepository;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IBookingDetailsService;
import com.cg.hbm.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookingDetailsServiceTest {

    @InjectMocks
    private IBookingDetailsService bookingDetailsService = new BookingDetailsService();

    @Mock
    private BookingDetailsRepository bookingDetailsRepository;


    @Test
    void addBookingDetails() {

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setBooking_id(36);
        Date booked_from = Date.valueOf(LocalDate.now());
        bookingDetails.setBooked_from(booked_from);
        Date booked_to = Date.valueOf(LocalDate.now());
        bookingDetails.setBooked_to(booked_to);
        int no_of_adults = 2;
        bookingDetails.setNo_of_adults(no_of_adults);
        int no_of_children = 1;
        bookingDetails.setNo_of_children(no_of_children);
        double amount = 5000;
        bookingDetails.setAmount(amount);

        when(bookingDetailsRepository.save(bookingDetails)).thenReturn(bookingDetails);

        BookingDetails newBooking = bookingDetailsService.addBookingDetails(bookingDetails);

        assertThat(newBooking.getAmount()).isEqualTo(amount);
        assertThat(newBooking.getBooked_from()).isEqualTo(booked_from);
    }

    @Test
    void removeBookingDetails() {

        BookingDetails bookingDetails = new BookingDetails();
        int booking_id = 36;
        bookingDetails.setBooking_id(booking_id);
        Date booked_from = Date.valueOf(LocalDate.now());
        bookingDetails.setBooked_from(booked_from);
        Date booked_to = Date.valueOf(LocalDate.now());
        bookingDetails.setBooked_to(booked_to);
        int no_of_adults = 2;
        bookingDetails.setNo_of_adults(no_of_adults);
        int no_of_children = 1;
        bookingDetails.setNo_of_children(no_of_children);
        double amount = 5000;
        bookingDetails.setAmount(amount);

        bookingDetailsService.removeBookingDetails(booking_id);

        verify(bookingDetailsRepository, times(1)).deleteById(booking_id);
    }

    @Test
    void showAllBookingDetails() {

        BookingDetails bookingDetails1 = new BookingDetails();
        bookingDetails1.setBooking_id(36);
        Date bf1 = Date.valueOf(LocalDate.now());
        bookingDetails1.setBooked_from(bf1);
        Date bt1 = Date.valueOf(LocalDate.now());
        bookingDetails1.setBooked_to(bt1);
        bookingDetails1.setNo_of_adults(2);
        bookingDetails1.setNo_of_children(1);
        bookingDetails1.setAmount(5000);

        BookingDetails bookingDetails2 = new BookingDetails();
        bookingDetails2.setBooking_id(37);
        Date bf2 = Date.valueOf(LocalDate.now());
        bookingDetails2.setBooked_from(bf2);
        Date bt2 = Date.valueOf(LocalDate.now());
        bookingDetails2.setBooked_to(bt2);
        bookingDetails2.setNo_of_adults(4);
        bookingDetails2.setNo_of_children(1);
        bookingDetails2.setAmount(6000);

        BookingDetails bookingDetails3 = new BookingDetails();
        bookingDetails3.setBooking_id(38);
        Date bf3 = Date.valueOf(LocalDate.now());
        bookingDetails3.setBooked_from(bf3);
        Date bt3 = Date.valueOf(LocalDate.now());
        bookingDetails3.setBooked_to(bt3);
        bookingDetails3.setNo_of_adults(3);
        bookingDetails3.setNo_of_children(2);
        bookingDetails3.setAmount(4000);

        List<BookingDetails> list = new ArrayList<>();
        list.add(bookingDetails1);
        list.add(bookingDetails2);
        list.add(bookingDetails3);

        when(bookingDetailsRepository.findAll()).thenReturn(list);

        List<BookingDetails> bookingDetails = bookingDetailsService.showAllBookingDetails();

        assertThat(bookingDetails.size()).isEqualTo(3);
    }

    @Test
    void showBookingDetails() {
        BookingDetails bookingDetails = new BookingDetails();
        int booking_id = 36;
        bookingDetails.setBooking_id(booking_id);
        Date booked_from = Date.valueOf(LocalDate.now());
        bookingDetails.setBooked_from(booked_from);
        Date booked_to = Date.valueOf(LocalDate.now());
        bookingDetails.setBooked_to(booked_to);
        int no_of_adults = 2;
        bookingDetails.setNo_of_adults(no_of_adults);
        int no_of_children = 1;
        bookingDetails.setNo_of_children(no_of_children);
        double amount = 5000;
        bookingDetails.setAmount(amount);

        when(bookingDetailsRepository.findById(booking_id)).thenReturn(Optional.of(bookingDetails));

        BookingDetails newBooking = bookingDetailsService.showBookingDetails(booking_id);
        assertThat(newBooking.getBooked_to()).isEqualTo(booked_to);
    }

    @Test
    void getBookingByIdWithException(){
        when(bookingDetailsRepository.findById(101)).thenThrow(BookingDetailsNotFoundException.class);
        assertThrows(BookingDetailsNotFoundException.class,()->bookingDetailsService.showBookingDetails(101));
    }
}
