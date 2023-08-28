package com.restfulapi.sales.rest.controller;

import com.restfulapi.sales.rest.ApiErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.restfulapi.sales.exception.invalidCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(invalidCode.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleInvalidCode(invalidCode invalidCode){
        String errorMessage = invalidCode.getMessage();
        return new ApiErrors(errorMessage);
    }
}
