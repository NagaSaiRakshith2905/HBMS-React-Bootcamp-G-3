package com.cg.hbm.exception_handler;

public class BookingDetailsNotFoundException extends RuntimeException{

    public BookingDetailsNotFoundException(String msg){
        super(msg);
    }
}
