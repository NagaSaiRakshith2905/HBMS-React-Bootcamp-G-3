package com.cg.hbm.exception_handler;

public class RoomDetailsNotFoundException extends RuntimeException{

    public RoomDetailsNotFoundException(String msg){
        super(msg);
    }
}
