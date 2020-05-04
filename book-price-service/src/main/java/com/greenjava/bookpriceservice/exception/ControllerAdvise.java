package com.greenjava.bookpriceservice.exception;

import com.greenjava.bookpriceservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice
@RestController
public class ControllerAdvise {


    @ExceptionHandler(BookNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse bookNotFoundException(BookNotFound bookNotFound) {

        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(bookNotFound.getMessage());
        errorResponse.setDate(new Date());
        return errorResponse;
    }
}
