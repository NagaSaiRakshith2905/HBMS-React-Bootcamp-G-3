package com.cg.hbm.exception_handler;

public class PaymentsNotFoundException extends RuntimeException{

    public PaymentsNotFoundException(String msg){
        super(msg);
    }
}
