package com.project.bookmyshow.bookmyshow.controllers;

import com.project.bookmyshow.bookmyshow.dtos.CreateBookingRequestDto;
import com.project.bookmyshow.bookmyshow.dtos.CreateBookingResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto){

        return null;
    }

}
