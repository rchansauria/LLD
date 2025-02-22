package com.project.bookmyshow.bookmyshow.exceptionHandler;

import com.project.bookmyshow.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.project.bookmyshow.bookmyshow.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException(UserNotFoundException userNotFoundException){

    }


    @ExceptionHandler(ShowSeatNotFoundException.class)
    public void handleUserNotFoundException(ShowSeatNotFoundException showSeatNotFoundException){

    }



}
