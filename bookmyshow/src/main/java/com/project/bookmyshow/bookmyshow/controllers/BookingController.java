package com.project.bookmyshow.bookmyshow.controllers;

import com.project.bookmyshow.bookmyshow.dtos.CreateBookingRequestDto;
import com.project.bookmyshow.bookmyshow.dtos.CreateBookingResponseDto;
import com.project.bookmyshow.bookmyshow.dtos.ResponseStatus;
import com.project.bookmyshow.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.project.bookmyshow.bookmyshow.exceptions.UserNotFoundException;
import com.project.bookmyshow.bookmyshow.models.Bookings;
import com.project.bookmyshow.bookmyshow.services.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto) throws UserNotFoundException, ShowSeatNotFoundException {
        CreateBookingResponseDto responseDto =new CreateBookingResponseDto();
        Bookings booking = bookingService.createBooking(createBookingRequestDto.getShowSeatIds(), createBookingRequestDto.getUser_id());
        if (booking == null) {
            responseDto.setStatus(ResponseStatus.FAILURE);
        }

        responseDto.setStatus(ResponseStatus.SUCCESS);

        return responseDto;
    }

}
