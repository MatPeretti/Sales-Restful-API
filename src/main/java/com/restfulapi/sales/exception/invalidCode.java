package com.restfulapi.sales.exception;

public class invalidCode extends RuntimeException {
    public invalidCode(String message){
        super(message);
    }
}
