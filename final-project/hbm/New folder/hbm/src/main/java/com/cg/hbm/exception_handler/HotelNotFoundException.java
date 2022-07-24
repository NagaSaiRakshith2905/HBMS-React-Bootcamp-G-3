package com.cg.hbm.exception_handler;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(String msg){
        super(msg);
    }
}

